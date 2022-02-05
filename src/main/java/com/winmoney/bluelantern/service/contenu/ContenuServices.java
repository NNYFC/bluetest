package com.winmoney.bluelantern.service.contenu;

import com.winmoney.bluelantern.dto.ContenuDtao;
import com.winmoney.bluelantern.model.Contenu;

import java.util.List;

public interface ContenuServices {
    Contenu addContenu(ContenuDtao contenuDtao);
    Contenu updateContenu(ContenuDtao contenuDtao,int id);
    List<Contenu> listContenuByIdcours(int idcours);
}
