package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.Service.ReserveService;
import com.github.zmilad97.reservationsystem.module.Reserve;
import com.github.zmilad97.reservationsystem.repository.ReserveRepository;
import com.github.zmilad97.reservationsystem.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve/")
public class ReserveController {
    private final ReserveService reserveService;
    private final ReserveRepository reserveRepository;

    @Autowired
    public ReserveController(ReserveService reserveService, ReserveRepository reserveRepository) {
        this.reserveService = reserveService;
        this.reserveRepository = reserveRepository;
    }


    @PostMapping("add")
    public void addReserve(@RequestBody Reserve reserve) {
        reserveService.save(reserve);
    }

    @PostMapping("update")
    public void updateReserve(@RequestBody Reserve reserve) {
        reserveService.update(reserve);
    }

    @DeleteMapping("remove/{id}")
    public void removeReserve(@PathVariable Long id) {
        reserveService.delete(reserveRepository.findReserveById(id));
    }

    @GetMapping("work/{workId}")
    public List<Reserve> workReservation(@PathVariable long workId) {
        return reserveService.findByWork(workId);
    }

    @GetMapping("my-reservations")
    public List<Reserve> myReservations() {
        return reserveRepository.findByUser(SecurityUtil.getCurrentUser());
    }


}
