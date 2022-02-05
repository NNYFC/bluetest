package com.winmoney.bluelantern.service.questionepreuve;

import com.winmoney.bluelantern.dto.QuestionepreuveDtao;
import com.winmoney.bluelantern.model.Epreuve;
import com.winmoney.bluelantern.model.Questionepreuve;
import com.winmoney.bluelantern.repository.EpreuveRepository;
import com.winmoney.bluelantern.repository.QuestionepreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionepreuveServicesImp implements QuestionepreuveServices {

    @Autowired
    QuestionepreuveRepository questionepreuveRepository;
    @Autowired
    EpreuveRepository epreuveRepository;

    @Override
    public Questionepreuve addQuestionepreuve(QuestionepreuveDtao questionepreuveDtao) {
        Questionepreuve questionepreuve = new Questionepreuve();
        Optional<Epreuve> optional = epreuveRepository.findById(questionepreuveDtao.getIdepreuve());
        if (optional.isPresent()){
            questionepreuve.setLibellequestionepreuve(questionepreuveDtao.getLibellequestionepreuve());
            questionepreuve.setIdepreuve(optional.get());
            return questionepreuveRepository.save(questionepreuve);
        }else {
            throw new RuntimeException("Epreuve not found for id = "+questionepreuveDtao.getIdepreuve());
        }
    }

    @Override
    public Questionepreuve updateQuestionepreuve(QuestionepreuveDtao questionepreuveDtao,int id) {
        Optional<Questionepreuve> optional = questionepreuveRepository.findById(id);
        if (optional.isPresent()){
            Questionepreuve questionepreuve = optional.get();
            questionepreuve.setLibellequestionepreuve(questionepreuveDtao.getLibellequestionepreuve());
            return questionepreuveRepository.save(questionepreuve);
        }else {
            throw new RuntimeException("No such questionepreuve with id = "+id);
        }

    }

    @Override
    public List<Questionepreuve> listEpreuveQuestions(int idEpreuve) {
        List<Questionepreuve> questionepreuves;
        Optional<Epreuve> optional = epreuveRepository.findById(idEpreuve);
        if (optional.isPresent()){
            questionepreuves = questionepreuveRepository.findAllQuestionsByEpreuveId(idEpreuve);
            return questionepreuves;
        }else {
            throw new RuntimeException("Epreuve not found for id = "+idEpreuve);
        }
    }

    @Override
    public String deleteQuestionepreuve(int id) {
        Optional<Questionepreuve> optional = questionepreuveRepository.findById(id);
        if (optional.isPresent()){
            questionepreuveRepository.deleteById(id);
        }else {
            throw new RuntimeException("Question Epreuve not found for id = "+id);
        }
        return "Deleted Successfully";
    }

}
