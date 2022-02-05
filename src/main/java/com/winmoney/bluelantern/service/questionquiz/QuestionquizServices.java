package com.winmoney.bluelantern.service.questionquiz;

import com.winmoney.bluelantern.dto.QuestionquizDtao;
import com.winmoney.bluelantern.model.Questionquiz;

import java.util.List;

public interface QuestionquizServices {
    Questionquiz addQuestionquiz(QuestionquizDtao questionquizDtao);
    Questionquiz updateQuestionquiz(QuestionquizDtao questionquizDtao,int id);
    List<Questionquiz> listQuizQuestions(int idQuiz);
    String deleteQuestionquiz(int id);
}
