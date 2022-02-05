package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
