package com.winmoney.bluelantern.service.questionquiz;

import com.winmoney.bluelantern.dto.QuestionquizDtao;
import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Quiz;
import com.winmoney.bluelantern.repository.QuestionquizRepository;
import com.winmoney.bluelantern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionquizServicesImp implements QuestionquizServices{

    @Autowired
    QuestionquizRepository questionquizRepository;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Questionquiz addQuestionquiz(QuestionquizDtao questionquizDtao) {
        Questionquiz questionquiz = new Questionquiz();
        Optional<Quiz> optional = quizRepository.findById(questionquizDtao.getIdquiz());
        if (optional.isPresent()){
            questionquiz.setLibellequestionquiz(questionquizDtao.getLibellequestionquiz());
            questionquiz.setIdquiz(optional.get());
            return questionquizRepository.save(questionquiz);
        }else {
            throw new RuntimeException("Quiz not found for id = "+questionquizDtao.getIdquiz());
        }
    }

    @Override
    public Questionquiz updateQuestionquiz(QuestionquizDtao questionquizDtao,int id) {
        return null;
    }

    @Override
    public List<Questionquiz> listQuizQuestions(int idQuiz) {
        List<Questionquiz> questionquiz;
        Optional<Quiz> optional = quizRepository.findById(idQuiz);
        if (optional.isPresent()){
            questionquiz = questionquizRepository.findAllQuestionsByQuiyId(idQuiz);
            return questionquiz;
        }else {
            throw new RuntimeException("Quiz not found for id = "+idQuiz);
        }
    }

    @Override
    public String deleteQuestionquiz(int id) {
        Optional<Questionquiz> optional = questionquizRepository.findById(id);
        if (optional.isPresent()){
            questionquizRepository.deleteById(id);
        }else {
            throw new RuntimeException("Question Quiz not found for id = "+id);
        }
        return "Deleted Successfully";
    }

}
