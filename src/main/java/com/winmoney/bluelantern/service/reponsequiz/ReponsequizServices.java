package com.winmoney.bluelantern.service.reponsequiz;

import com.winmoney.bluelantern.dto.ReponsequizDtao;
import com.winmoney.bluelantern.model.Reponsequiz;

import java.util.List;

public interface ReponsequizServices {
    Reponsequiz addReponsequiz(ReponsequizDtao reponsequizDtao);
    Reponsequiz updateReponsequiz(ReponsequizDtao reponsequizDtao,int id);
    List<Reponsequiz> listReponseQuizByQuestionId(int id);
    String deleteReponsequiz(int id);
}
