package com.winmoney.bluelantern.service.epreuve;

import com.winmoney.bluelantern.model.Epreuve;
import com.winmoney.bluelantern.model.Quiz;
import com.winmoney.bluelantern.repository.EpreuveRepository;
import com.winmoney.bluelantern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpreuveServicesImp implements EpreuveServices {
    @Autowired
    EpreuveRepository epreuveRepository;

    @Override
    public Epreuve addEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    @Override
    public Epreuve updateEpreuve(Epreuve epreuve,int id) {
        Optional<Epreuve> optional = epreuveRepository.findById(id);
        if (optional.isPresent()){
            Epreuve epreuve1 = optional.get();
            epreuve1.setDescriptionepreuve(epreuve.getDescriptionepreuve());
            epreuve1.setLibelleepreuve(epreuve.getLibelleepreuve());
            return epreuveRepository.save(epreuve1);
        }else {
            throw new RuntimeException("Epreuve not found for id = "+id);
        }
    }

    @Override
    public String deleteEpreuve(int id) {
        Optional<Epreuve> optional = epreuveRepository.findById(id);
        if (optional.isPresent()){
            epreuveRepository.deleteById(id);
        }else {
            throw new RuntimeException("Epreuve not found for id = "+id);
        }
        return "Deleted Successfully";
    }

    @Override
    public List<Epreuve> listAllEpreuve() {
        return epreuveRepository.findAll();
    }

}
