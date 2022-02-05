package com.winmoney.bluelantern.service.anneeacademique;

import com.winmoney.bluelantern.dto.UtilisateuranneeacademiqueDtao;
import com.winmoney.bluelantern.model.Anneeacademique;
import com.winmoney.bluelantern.model.Utilisateuranneeacademique;

import java.util.List;

public interface AnneeacademiqueServices {
    Anneeacademique addAnneeacademique(Anneeacademique anneeacademique);
    List<Anneeacademique> listAnneeacademique();
    Utilisateuranneeacademique addUtilisateuranneeacademique(UtilisateuranneeacademiqueDtao utilisateuranneeacademiqueDtao);
}
