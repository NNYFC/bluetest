package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Questionepreuve;
import com.winmoney.bluelantern.model.Reponseepreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseepreuveRepository extends JpaRepository<Reponseepreuve,Integer> {
    List<Reponseepreuve> findAllReponsequizByQuestionId(Questionepreuve idquestionepreuve);
}
