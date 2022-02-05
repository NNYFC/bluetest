package com.winmoney.bluelantern.service.score;

import com.winmoney.bluelantern.dto.ScoreDtao;
import com.winmoney.bluelantern.model.*;
import com.winmoney.bluelantern.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreServicesImp implements ScoreServices{

    @Autowired
    ScorequizRepository scorequizRepository;
    @Autowired
    ScoreepreuveRepository scoreepreuveRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    EpreuveRepository epreuveRepository;

    @Override
    public Scorequiz addScorequiz(ScoreDtao scoreDtao) {
        Optional<Utilisateur> optional = utilisateurRepository.findById(scoreDtao.getIdutilisateur());
        Optional<Quiz> optional1 = quizRepository.findById(scoreDtao.getIdquiz());
        if (optional.isPresent() && optional1.isPresent()){
            Scorequiz scorequiz = new Scorequiz(
                    scoreDtao.getLibellescore(),
                    scoreDtao.getDatescorequiz(),
                    optional1.get(),
                    optional.get()
            );
            return scorequizRepository.save(scorequiz);
        }else{
            throw new RuntimeException("User or Quiz id not found");
        }

    }

    @Override
    public Scorequiz listScorequizByUserIdUserId(long id) {
        return scorequizRepository.findUserScoreById(id);
    }

    @Override
    public Scoreepreuve addScoreepreuve(ScoreDtao scoreDtao) {
        Optional<Utilisateur> optional = utilisateurRepository.findById(scoreDtao.getIdutilisateur());
        Optional<Epreuve> optional1 = epreuveRepository.findById(scoreDtao.getIdquiz());
        if (optional.isPresent() && optional1.isPresent()){
            Scoreepreuve scorequiz = new Scoreepreuve(
                    scoreDtao.getLibellescore(),
                    scoreDtao.getDatescorequiz(),
                    optional1.get(),
                    optional.get()
            );
            return scoreepreuveRepository.save(scorequiz);
        }else{
            throw new RuntimeException("User or Quiz id not found");
        }
    }

    @Override
    public Scoreepreuve listScoreepreuveByUserId(long id) {
        return scoreepreuveRepository.findUserScoreById(id);
    }

}
