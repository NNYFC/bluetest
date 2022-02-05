package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Questionepreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionepreuveRepository extends JpaRepository<Questionepreuve,Integer> {
    List<Questionepreuve> findAllQuestionsByEpreuveId(int idepreuve);
}
