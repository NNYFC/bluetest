package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {
    List<Cours> findCoursByidAnneeacademique(int idanneeacademique);
}
