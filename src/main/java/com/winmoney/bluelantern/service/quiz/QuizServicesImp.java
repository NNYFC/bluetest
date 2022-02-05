package com.winmoney.bluelantern.service.quiz;

import com.winmoney.bluelantern.model.Quiz;
import com.winmoney.bluelantern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServicesImp implements QuizServices {
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz,int id) {
        Optional<Quiz> optional = quizRepository.findById(id);
        if (optional.isPresent()){
            return quizRepository.save(quiz);
        }else {
            throw new RuntimeException("Quiz not found for id = "+id);
        }
    }

    @Override
    public String deleteQuiz(int id) {
        Optional<Quiz> optional = quizRepository.findById(id);
        if (optional.isPresent()){
            quizRepository.deleteById(id);
        }else {
            throw new RuntimeException("Quiz not found for id = "+id);
        }
        return "Deleted Successfully";
    }

    @Override
    public List<Quiz> listAllQuiz() {
        return quizRepository.findAll();
    }

}
