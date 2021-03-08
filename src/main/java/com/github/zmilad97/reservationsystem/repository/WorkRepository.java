package com.github.zmilad97.reservationsystem.repository;

import com.github.zmilad97.reservationsystem.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work,Long> {

    Work findWorkById(long id);
    Work findByTitle(String title);
    List<Work> findByTitleContains(String title);
    List<Work> findByTitleContaining(String title);
    boolean existsByTitle(String title);


}
