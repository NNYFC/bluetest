package com.winmoney.bluelantern.service.cours;

import com.winmoney.bluelantern.dto.CourDtao;
import com.winmoney.bluelantern.model.Cours;

import java.util.List;

public interface CourServices {
    Cours addCours(CourDtao courDtao);
    List<Cours> getCoursByAnneeId(int id);
    Cours updateCours(CourDtao courDtao,int id);
    List<Cours> getAllCours();
}
