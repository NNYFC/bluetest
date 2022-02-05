package com.winmoney.bluelantern.service.quiz;

import com.winmoney.bluelantern.model.Quiz;

import java.util.List;

public interface QuizServices {
    Quiz addQuiz(Quiz quiz);
    Quiz updateQuiz(Quiz quiz,int id);
    String deleteQuiz(int id);
    List<Quiz> listAllQuiz();
}
