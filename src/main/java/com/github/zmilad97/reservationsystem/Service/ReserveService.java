package com.github.zmilad97.reservationsystem.Service;

import com.github.zmilad97.reservationsystem.model.Reserve;
import com.github.zmilad97.reservationsystem.model.User;
import com.github.zmilad97.reservationsystem.model.Work;
import com.github.zmilad97.reservationsystem.repository.ReserveRepository;
import com.github.zmilad97.reservationsystem.repository.WorkRepository;
import com.github.zmilad97.reservationsystem.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final WorkRepository workRepository;
//    private static final Logger LOG = LoggerFactory.getLogger(ReserveService.class);

    @Autowired
    public ReserveService(ReserveRepository reserveRepository, WorkRepository workRepository) {
        this.reserveRepository = reserveRepository;
        this.workRepository = workRepository;
    }

    public void save(Reserve reserve) {
//        resolveConflictDateAndTime(reserve.getDate(), reserve.getTime(), reserve.getWork());
        if (!(SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")
                || reserve.getWork().getOwner().equals(SecurityUtil.getCurrentUser())))
            reserve.setApproved(false);
        if(reserve.getUser() == null)
            reserve.setUser(SecurityUtil.getCurrentUser());
        reserveRepository.save(reserve);
    }

    public void delete(Reserve reserve) {
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser.getRoleList().contains("ROLE_ADMIN") || reserve.getUser().equals(currentUser)
                || reserve.getWork().getOwner().equals(currentUser))
            reserveRepository.delete(reserve);
    }

    public void update(Reserve reserve) {
        if (SecurityUtil.getCurrentUser().getRoleList().contains("ROLE_ADMIN")
                || reserve.getWork().getOwner().equals(SecurityUtil.getCurrentUser())
                || (!reserve.isApproved() && reserve.getUser().equals(SecurityUtil.getCurrentUser()))
        )
            reserveRepository.save(reserve);
    }

    public List<Reserve> findByWork(long workId) {
        Work work = workRepository.findWorkById(workId);
        List<Reserve> reserveList = new ArrayList<>();
        if (work.getOwner().equals(SecurityUtil.getCurrentUser()))
            reserveList = reserveRepository.findReserveByWork(work);
        return reserveList;
    }




   /* public boolean resolveConflictDateAndTime(LocalDate date, LocalTime time, Work work) {
        Map<LocalTime, LocalTime> timeTable = work.getScheduleTimeTableMapOfDay(DayOfWeek.from(date));
        timeTable.forEach((key, value) -> {
            if (time.equals(key))

        });
        return false;
    }
*/

}
