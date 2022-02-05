package com.winmoney.bluelantern.service.filiere;

import com.winmoney.bluelantern.model.Filiere;

import java.util.List;

public interface FiliereServices {
    Filiere addFiliere(Filiere filiere);
    List<Filiere> getAllFiliere();
    Filiere updateFiliere(Filiere filiere,Long id);
    String deleteFiliere(Long id);
}
