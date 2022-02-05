package com.winmoney.bluelantern.service.niveaufiliere;

import com.winmoney.bluelantern.dto.NiveaufiliereDtao;
import com.winmoney.bluelantern.model.Filiere;
import com.winmoney.bluelantern.model.Niveau;
import com.winmoney.bluelantern.model.Niveaufiliere;
import com.winmoney.bluelantern.repository.FiliereRepository;
import com.winmoney.bluelantern.repository.NiveauRepository;
import com.winmoney.bluelantern.repository.NiveaufiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveaufiliereServicesImp implements NiveaufiliereServices{

    @Autowired
    NiveaufiliereRepository niveaufiliereRepository;

    @Autowired
    FiliereRepository filiereRepository;

    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveaufiliere addNiveaufiliere(NiveaufiliereDtao niveaufiliereDtao) {
        Niveaufiliere niveaufiliere = new Niveaufiliere();
        Optional<Filiere> optional = filiereRepository.findById(niveaufiliereDtao.getIdfiliere());
        Optional<Niveau> optional1 = niveauRepository.findById(niveaufiliereDtao.getIdniveau());
        if (optional.isPresent() && optional1.isPresent()){
            niveaufiliere.setIdfiliere(optional.get());
            niveaufiliere.setIdniveau(optional1.get());
        }else {
            throw new RuntimeException("Filiere or Niveau not found for id = "+niveaufiliereDtao.getIdfiliere()+" or "+niveaufiliereDtao.getIdniveau());
        }
        return niveaufiliereRepository.save(niveaufiliere);
    }

    @Override
    public List<Niveaufiliere> getAllNiveauFiliere() {
        return niveaufiliereRepository.findAll();
    }

}
