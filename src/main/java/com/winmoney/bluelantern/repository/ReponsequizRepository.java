package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Reponsequiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponsequizRepository extends JpaRepository<Reponsequiz,Integer> {
    List<Reponsequiz> findAllReponsequizByQuestionId(Questionquiz idquestionquiz);
}
