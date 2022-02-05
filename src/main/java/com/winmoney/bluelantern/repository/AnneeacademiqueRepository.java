package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Anneeacademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeacademiqueRepository extends JpaRepository<Anneeacademique,Integer> {
}
