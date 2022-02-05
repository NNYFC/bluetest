package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Scoreepreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreepreuveRepository extends JpaRepository<Scoreepreuve,Integer> {
    Scoreepreuve findUserScoreById(long idutilisateur);
}
