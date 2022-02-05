package com.winmoney.bluelantern.service.contenu;

import com.winmoney.bluelantern.dto.ContenuDtao;
import com.winmoney.bluelantern.model.Contenu;
import com.winmoney.bluelantern.model.Cours;
import com.winmoney.bluelantern.repository.ContenuRepository;
import com.winmoney.bluelantern.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenuServicesImp implements ContenuServices{

    @Autowired
    ContenuRepository contenuRepository;

    @Autowired
    CoursRepository coursRepository;

    @Override
    public Contenu addContenu(ContenuDtao contenuDtao) {
        Optional<Cours> optional = coursRepository.findById(contenuDtao.getIdcours());
        if (optional.isPresent()){
            Contenu contenu = new Contenu(
                    contenuDtao.getLibellecontenu(),
                    contenuDtao.getDescriptioncontenu(),
                    contenuDtao.getDocumentcontenu(),
                    optional.get()
            );
            return contenuRepository.save(contenu);
        }else {
            throw new RuntimeException("No Cours with this id = "+contenuDtao.getIdcours());
        }

    }

    @Override
    public Contenu updateContenu(ContenuDtao contenuDtao, int id) {
        Optional<Contenu> optional = contenuRepository.findById(id);
        if (optional.isPresent()){

            Contenu contenu = optional.get();
            contenu.setDescriptioncontenu(contenuDtao.getDescriptioncontenu());
            contenu.setDocumentcontenu(contenuDtao.getDocumentcontenu());
            contenu.setLibellecontenu(contenuDtao.getLibellecontenu());

            return contenuRepository.save(contenu);
        }else {
            throw new RuntimeException("No such contenu with id = "+id);
        }

    }

    @Override
    public List<Contenu> listContenuByIdcours(int idcours) {
        return contenuRepository.findAllByIdcours(idcours);
    }
}
