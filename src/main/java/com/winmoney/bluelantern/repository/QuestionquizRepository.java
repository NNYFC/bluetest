package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionquizRepository extends JpaRepository<Questionquiz,Integer> {
    List<Questionquiz> findAllQuestionsByQuiyId(int idquiz);
}
