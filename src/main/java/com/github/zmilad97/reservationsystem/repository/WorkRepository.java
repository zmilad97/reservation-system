package com.github.zmilad97.reservationsystem.repository;

import com.github.zmilad97.reservationsystem.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work,Long> {

    Work findWorkById(long id);
    Work findByTitle(String title);
    Work findByTitleContains(String title);
    boolean existsByTitle(String title);


}
