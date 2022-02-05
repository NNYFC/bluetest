package com.winmoney.bluelantern.service.utilisateurquestionquiz;

import com.winmoney.bluelantern.dto.UtilisateurquestionquizDtao;
import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Utilisateur;
import com.winmoney.bluelantern.model.Utilisateurquestionquiz;
import com.winmoney.bluelantern.repository.QuestionquizRepository;
import com.winmoney.bluelantern.repository.UtilisateurRepository;
import com.winmoney.bluelantern.repository.UtilisateurquestionquizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurquestionquizServiceImp implements UtilisateurquestionquizService{

    @Autowired
    UtilisateurquestionquizRepository utilisateurquestionquizRepository;

    @Autowired
    QuestionquizRepository questionquizRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateurquestionquiz addUtilisateurquestionquiz(UtilisateurquestionquizDtao utilisateurquestionquizDtao) {
        Optional<Questionquiz> optional = questionquizRepository.findById(utilisateurquestionquizDtao.getIdquestionquiz());
        Optional<Utilisateur> optional1 = utilisateurRepository.findById(utilisateurquestionquizDtao.getIdutilisateur());
        Utilisateurquestionquiz utilisateurquestionquiz = new Utilisateurquestionquiz(
                utilisateurquestionquizDtao.getDateutilisateurquestionquiz(),
                optional.get(),
                optional1.get()
        );
        return utilisateurquestionquizRepository.save(utilisateurquestionquiz);
    }

    @Override
    public Utilisateurquestionquiz getLastUserQuestionquiz(long idutilisateur, int idquiz) {
        return utilisateurquestionquizRepository.findUserlastQuestionquiz(idutilisateur,idquiz);
    }
}
