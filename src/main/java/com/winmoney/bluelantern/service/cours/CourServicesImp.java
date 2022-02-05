package com.winmoney.bluelantern.service.cours;

import com.winmoney.bluelantern.dto.CourDtao;
import com.winmoney.bluelantern.model.Anneeacademique;
import com.winmoney.bluelantern.model.Cours;
import com.winmoney.bluelantern.repository.AnneeacademiqueRepository;
import com.winmoney.bluelantern.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourServicesImp implements CourServices{

    @Autowired
    CoursRepository coursRepository;

    @Autowired
    AnneeacademiqueRepository anneeacademiqueRepository;

    @Override
    public Cours addCours(CourDtao courDtao) {
        Optional<Anneeacademique> optional = anneeacademiqueRepository.findById(courDtao.getIdanneeacademique());
        if (optional.isPresent()){
            Cours cours = new Cours(
                    courDtao.getLibellecours(),
                    courDtao.getNombreheurecours(),
                    optional.get()
            );
            return coursRepository.save(cours);
        }else {
            throw new RuntimeException("No such anneeacademique with id = "+courDtao.getIdanneeacademique());
        }

    }

    @Override
    public List<Cours> getCoursByAnneeId(int id) {
        return coursRepository.findCoursByidAnneeacademique(id);
    }

    @Override
    public Cours updateCours(CourDtao courDtao, int id) {
        Optional<Cours> optional = coursRepository.findById(id);
        Optional<Anneeacademique> optional1 = anneeacademiqueRepository.findById(courDtao.getIdanneeacademique());
        if (optional.isPresent()){
            Cours cours = optional.get();
            cours.setLibellecours(courDtao.getLibellecours());
            cours.setNombreheurecours(courDtao.getNombreheurecours());
            cours.setIdanneeacademique(optional1.get());
            return coursRepository.save(cours);
        }else {
            throw new RuntimeException("No such cours with id = "+id);
        }
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }
}
