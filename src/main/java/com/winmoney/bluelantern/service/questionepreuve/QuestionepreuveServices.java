package com.winmoney.bluelantern.service.questionepreuve;



import com.winmoney.bluelantern.dto.QuestionepreuveDtao;
import com.winmoney.bluelantern.model.Questionepreuve;

import java.util.List;

public interface QuestionepreuveServices {
    Questionepreuve addQuestionepreuve(QuestionepreuveDtao questionepreuveDtao);
    Questionepreuve updateQuestionepreuve(QuestionepreuveDtao questionepreuveDtao, int id);
    List<Questionepreuve> listEpreuveQuestions(int idEpreuve);
    String deleteQuestionepreuve(int id);
}
