package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Utilisateurquestionquiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurquestionquizRepository extends JpaRepository<Utilisateurquestionquiz,Integer> {
    Utilisateurquestionquiz findUserlastQuestionquiz(long idutilisateur, int idquiz);
}
