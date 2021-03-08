package com.github.zmilad97.reservationsystem.Service;

import com.github.zmilad97.reservationsystem.model.Schedule;
import com.github.zmilad97.reservationsystem.model.Work;
import com.github.zmilad97.reservationsystem.repository.WorkRepository;
import com.github.zmilad97.reservationsystem.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Service
public class WorkService {

    private final WorkRepository workRepository;

    @Autowired
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public void save(Work work) {
        if (SecurityUtil.getCurrentUser().getRoleList().contains("OWNER")||SecurityUtil.getCurrentUser().getRoleList().contains("ADMIN")) {

            if (work.getOwner() == null)
                work.setOwner(SecurityUtil.getCurrentUser());
            if (work.getSchedule() == null)
                work.setSchedule(new HashSet<>());

            workRepository.save(work);
        }
    }

    public void setStatus(boolean status, long id) {
        Work work = workRepository.findWorkById(id);
        if (SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_OWNER") &&
                (SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")
                        || work.getOwner().equals(SecurityUtil.getCurrentUser()))) {
            work.setOpen(status);
            workRepository.save(work);
        }
    }

    public void update(long id, Work work) {
        Work original = workRepository.findWorkById(id);

        if (SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_OWNER") &&
                (SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")
                        || original.getOwner().equals(SecurityUtil.getCurrentUser()))) {

            work.setId(id);
            if (work.getOwner() == null)
                work.setOwner(original.getOwner());
            if (work.getInformation() == null || work.getInformation().equals(""))
                work.setInformation(original.getInformation());
            if (work.getTitle() == null || work.getTitle().equals(""))
                work.setTitle(original.getTitle());
            if (work.getSchedule() == null)
                work.setSchedule(original.getSchedule());

            workRepository.save(work);

        }
    }

    public void addSchedule(Schedule schedule, long id) {
        Work work = workRepository.findWorkById(id);
        if (work.getOwner().equals(SecurityUtil.getCurrentUser())
                || SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")) {
            work.addSchedule(schedule);
            workRepository.save(work);
        }
    }

    public void setInformation(String information, long id) {
        Work work = workRepository.findWorkById(id);
        if (work.getOwner().equals(SecurityUtil.getCurrentUser())
                || SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")) {
            work.setInformation(information);
            workRepository.save(work);
        }
    }

    public void setTitle(String title, long id) {
        Work work = workRepository.findWorkById(id);
        if (work.getOwner().equals(SecurityUtil.getCurrentUser())
                || SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")) {
            if (!(workRepository.existsByTitle(title)))
                work.setTitle(title);
            workRepository.save(work);
        }
    }

    public Map<Long,String> findByTitleContains(String title){
        HashMap<Long,String> workmap = new HashMap();

        workRepository.findByTitleContaining(title).forEach((e) -> workmap.put(e.getId() ,e.getTitle()));

        return workmap;
    }
}
