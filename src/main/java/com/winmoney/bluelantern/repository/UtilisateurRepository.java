package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmailutilisateur(String emailutilisateur);
}
