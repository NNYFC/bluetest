package com.winmoney.bluelantern.service.niveaufiliere;

import com.winmoney.bluelantern.dto.NiveaufiliereDtao;
import com.winmoney.bluelantern.model.Niveaufiliere;

import java.util.List;

public interface NiveaufiliereServices {
    Niveaufiliere addNiveaufiliere(NiveaufiliereDtao niveaufiliereDtao);
    List<Niveaufiliere> getAllNiveauFiliere();
}
