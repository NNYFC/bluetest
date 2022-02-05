package com.winmoney.bluelantern.service.niveau;


import com.winmoney.bluelantern.model.Niveau;

import java.util.List;

public interface NiveauServices {
    Niveau addNiveau(Niveau niveau);
    List<Niveau> getAllNiveau();
    Niveau updateNiveau(Niveau niveau,Long id);
}
