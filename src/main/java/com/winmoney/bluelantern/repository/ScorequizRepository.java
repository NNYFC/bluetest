package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Scorequiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScorequizRepository extends JpaRepository<Scorequiz,Integer> {
    Scorequiz findUserScoreById(long idutilisateur);
}
