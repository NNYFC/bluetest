package com.winmoney.bluelantern.service.reponseepreuve;



import com.winmoney.bluelantern.dto.ReponseepreuveDtao;
import com.winmoney.bluelantern.model.Reponseepreuve;

import java.util.List;

public interface ReponseepreuveServices {
    Reponseepreuve addReponseepreuve(ReponseepreuveDtao reponseepreuveDtao);
    Reponseepreuve updateReponseepreuve(ReponseepreuveDtao reponseepreuveDtao,int id);
    List<Reponseepreuve> listReponseEpreuveByQuestionId(int id);
    String deleteReponseepreuve(int id);
}
