package com.winmoney.bluelantern.service.anneeacademique;

import com.winmoney.bluelantern.dto.UtilisateuranneeacademiqueDtao;
import com.winmoney.bluelantern.model.Anneeacademique;
import com.winmoney.bluelantern.model.Niveaufiliere;
import com.winmoney.bluelantern.model.Utilisateur;
import com.winmoney.bluelantern.model.Utilisateuranneeacademique;
import com.winmoney.bluelantern.repository.AnneeacademiqueRepository;
import com.winmoney.bluelantern.repository.NiveaufiliereRepository;
import com.winmoney.bluelantern.repository.UtilisateurRepository;
import com.winmoney.bluelantern.repository.UtilisateuranneeacademiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneeacademiqueServicesImp implements AnneeacademiqueServices {

    @Autowired
    AnneeacademiqueRepository anneeacademiqueRepository;

    @Autowired
    UtilisateuranneeacademiqueRepository utilisateuranneeacademiqueRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    NiveaufiliereRepository niveaufiliereRepository;


    @Override
    public Anneeacademique addAnneeacademique(Anneeacademique anneeacademique) {
        return anneeacademiqueRepository.save(anneeacademique);
    }

    @Override
    public List<Anneeacademique> listAnneeacademique() {
        return anneeacademiqueRepository.findAll();
    }

    @Override
    public Utilisateuranneeacademique addUtilisateuranneeacademique(UtilisateuranneeacademiqueDtao utilisateuranneeacademiqueDtao) {
        Optional<Utilisateur> optional = utilisateurRepository.findById(utilisateuranneeacademiqueDtao.getIdutilisateur());
        Optional<Niveaufiliere> optional1 = niveaufiliereRepository.findById(utilisateuranneeacademiqueDtao.getIdniveaufiliere());
        Optional<Anneeacademique> optional2 = anneeacademiqueRepository.findById(utilisateuranneeacademiqueDtao.getIdanneeacademique());

        if (optional.isPresent() && optional1.isPresent() && optional2.isPresent()){
            Utilisateuranneeacademique inscrit = new Utilisateuranneeacademique(
                    optional2.get(),
                    optional.get(),
                    optional1.get()
            );
            return utilisateuranneeacademiqueRepository.save(inscrit);
        }else {
            throw new RuntimeException("Id of user,niveuafiiere or anneeacademique not found");
        }
    }
}
