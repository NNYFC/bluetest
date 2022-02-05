package com.winmoney.bluelantern.service.reponseepreuve;


import com.winmoney.bluelantern.dto.ReponseepreuveDtao;
import com.winmoney.bluelantern.model.Questionepreuve;
import com.winmoney.bluelantern.model.Reponseepreuve;
import com.winmoney.bluelantern.repository.QuestionepreuveRepository;
import com.winmoney.bluelantern.repository.ReponseepreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseepreuveServicesImp implements ReponseepreuveServices {

    @Autowired
    ReponseepreuveRepository reponseepreuveRepository;

    @Autowired
    QuestionepreuveRepository questionepreuveRepository;

    @Override
    public Reponseepreuve addReponseepreuve(ReponseepreuveDtao reponseepreuveDtao) {
        Reponseepreuve reponseepreuve = new Reponseepreuve();
        Optional<Questionepreuve> optional = questionepreuveRepository.findById(reponseepreuveDtao.getIdquestionepreuve());
        if (optional.isPresent()){
            reponseepreuve.setLibellereponseepreuve(reponseepreuveDtao.getLibellereponseepreuve());
            reponseepreuve.setBonreponseepreuve(reponseepreuveDtao.getBonreponseepreuve());
            reponseepreuve.setIdquestionepreuve(optional.get());
        }else {
            throw new RuntimeException("Question not found for id = "+reponseepreuveDtao.getIdquestionepreuve());
        }
        return reponseepreuveRepository.save(reponseepreuve);
    }

    @Override
    public Reponseepreuve updateReponseepreuve(ReponseepreuveDtao reponseepreuveDtao, int id) {
        Optional<Reponseepreuve> optional = reponseepreuveRepository.findById(id);
        if (optional.isPresent()){
            optional.get().setLibellereponseepreuve(reponseepreuveDtao.getLibellereponseepreuve());
            optional.get().setBonreponseepreuve(reponseepreuveDtao.getBonreponseepreuve());
            return reponseepreuveRepository.save(optional.get());
        }else {
            throw new RuntimeException("No such Responseepreuve with id = "+id);
        }

    }

    @Override
    public List<Reponseepreuve> listReponseEpreuveByQuestionId(int id) {
        List<Reponseepreuve> reponsequiz;
        Optional<Questionepreuve> optional = questionepreuveRepository.findById(id);
        if (optional.isPresent()){
            reponsequiz= reponseepreuveRepository.findAllReponsequizByQuestionId(optional.get());
        }else {
            throw new RuntimeException("Quiz not found for id = "+id);
        }
        return reponsequiz;
    }

    @Override
    public String deleteReponseepreuve(int id) {
        Optional<Reponseepreuve> optional = reponseepreuveRepository.findById(id);
        if (optional.isPresent()){
            reponseepreuveRepository.deleteById(id);
        }else {
            throw new RuntimeException("Answer not found for id = "+id);
        }
        return "Deleted Successfully";
    }
}
