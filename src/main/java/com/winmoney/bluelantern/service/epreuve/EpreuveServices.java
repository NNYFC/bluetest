package com.winmoney.bluelantern.service.epreuve;

import com.winmoney.bluelantern.model.Epreuve;
import com.winmoney.bluelantern.model.Quiz;

import java.util.List;

public interface EpreuveServices {
    Epreuve addEpreuve(Epreuve epreuve);
    Epreuve updateEpreuve(Epreuve epreuve,int id);
    String deleteEpreuve(int id);
    List<Epreuve> listAllEpreuve();
}
