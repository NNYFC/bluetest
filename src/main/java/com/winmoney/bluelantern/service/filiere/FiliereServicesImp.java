package com.winmoney.bluelantern.service.filiere;

import com.winmoney.bluelantern.model.Filiere;
import com.winmoney.bluelantern.model.Utilisateur;
import com.winmoney.bluelantern.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereServicesImp implements FiliereServices{


    @Autowired
    FiliereRepository filiereRepository;

    @Override
    public Filiere addFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public List<Filiere> getAllFiliere() {
        return filiereRepository.findAll();
    }

    @Override
    public Filiere updateFiliere(Filiere filiere,Long id) {
        Optional<Filiere> optional = filiereRepository.findById(id);
        if (optional.isPresent()){
            return filiereRepository.save(filiere);
        }else {
            throw new RuntimeException("Filiere not found for id = "+id);
        }

    }

    @Override
    public String deleteFiliere(Long id) {
        Optional<Filiere> optional = filiereRepository.findById(id);
        if (optional.isPresent()){
            filiereRepository.deleteById(id);
        }else {
            throw new RuntimeException("Filiere not found for id = "+id);
        }
        return "Deleted Successfully";
    }
}
