package com.winmoney.bluelantern.service.niveau;

import com.winmoney.bluelantern.model.Niveau;
import com.winmoney.bluelantern.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServicesImp implements NiveauServices {

    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveau addNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public List<Niveau> getAllNiveau() {
        return niveauRepository.findAll();
    }

    @Override
    public Niveau updateNiveau(Niveau niveau,Long id) {
        Optional<Niveau> optional = niveauRepository.findById(id);
        if (optional.isPresent()){
            return niveauRepository.save(niveau);
        }else{
            throw new RuntimeException("No Niveau with such id = "+id);
        }
    }
}
