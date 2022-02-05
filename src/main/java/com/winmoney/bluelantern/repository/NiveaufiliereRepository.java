package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Niveaufiliere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveaufiliereRepository extends JpaRepository<Niveaufiliere,Long> {
}
