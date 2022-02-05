package com.winmoney.bluelantern.service.reponsequiz;

import com.winmoney.bluelantern.dto.ReponsequizDtao;
import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Quiz;
import com.winmoney.bluelantern.model.Reponsequiz;
import com.winmoney.bluelantern.repository.QuestionquizRepository;
import com.winmoney.bluelantern.repository.ReponsequizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponsequizServicesImp implements ReponsequizServices{

    @Autowired
    ReponsequizRepository reponsequizRepository;

    @Autowired
    QuestionquizRepository questionquizRepository;

    @Override
    public Reponsequiz addReponsequiz(ReponsequizDtao reponsequizDtao) {
        Reponsequiz reponsequiz = new Reponsequiz();
        Optional<Questionquiz> optional = questionquizRepository.findById(reponsequizDtao.getIdquestionquiz());
        if (optional.isPresent()){
            reponsequiz.setLibellereponsequiz(reponsequizDtao.getLibellereponsequiz());
            reponsequiz.setBonreponsequiz(reponsequizDtao.getBonreponsequiz());
            reponsequiz.setIdquestionquiz(optional.get());
        }else {
            throw new RuntimeException("Quiz not found for id = "+reponsequizDtao.getIdquestionquiz());
        }
        return reponsequizRepository.save(reponsequiz);
    }

    @Override
    public Reponsequiz updateReponsequiz(ReponsequizDtao reponsequizDtao,int id) {
        Optional<Reponsequiz> optional = reponsequizRepository.findById(id);
        if (optional.isPresent()){
            optional.get().setLibellereponsequiz(reponsequizDtao.getLibellereponsequiz());
            optional.get().setBonreponsequiz(reponsequizDtao.getBonreponsequiz());
            return reponsequizRepository.save(optional.get());
        }else {
            throw new RuntimeException("No such reponsequiz with id = "+id);
        }

    }

    @Override
    public List<Reponsequiz> listReponseQuizByQuestionId(int id) {
        List<Reponsequiz> reponsequiz;
        Optional<Questionquiz> optional = questionquizRepository.findById(id);
        if (optional.isPresent()){
            reponsequiz= reponsequizRepository.findAllReponsequizByQuestionId(optional.get());
        }else {
            throw new RuntimeException("Quiz not found for id = "+id);
        }
        return reponsequiz;
    }

    @Override
    public String deleteReponsequiz(int id) {
        Optional<Reponsequiz> optional = reponsequizRepository.findById(id);
        if (optional.isPresent()){
            reponsequizRepository.deleteById(id);
        }else {
            throw new RuntimeException("Answer not found for id = "+id);
        }
        return "Deleted Successfully";
    }

}
