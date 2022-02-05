package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Utilisateuranneeacademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateuranneeacademiqueRepository extends JpaRepository<Utilisateuranneeacademique,Integer> {
}
