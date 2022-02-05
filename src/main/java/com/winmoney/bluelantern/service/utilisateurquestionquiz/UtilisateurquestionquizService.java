package com.winmoney.bluelantern.service.utilisateurquestionquiz;

import com.winmoney.bluelantern.dto.UtilisateurquestionquizDtao;
import com.winmoney.bluelantern.model.Utilisateurquestionquiz;

public interface UtilisateurquestionquizService {
    Utilisateurquestionquiz addUtilisateurquestionquiz(UtilisateurquestionquizDtao utilisateurquestionquizDtao);
    Utilisateurquestionquiz getLastUserQuestionquiz(long idutilisateur,int idquiz);
}
