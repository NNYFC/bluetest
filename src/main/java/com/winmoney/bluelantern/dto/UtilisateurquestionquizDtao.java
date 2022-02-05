package com.winmoney.bluelantern.dto;

import java.util.Date;

public class UtilisateurquestionquizDtao {
    private Date dateutilisateurquestionquiz;
    private int idquestionquiz;
    private long idutilisateur;

    public UtilisateurquestionquizDtao() {
    }

    public UtilisateurquestionquizDtao(Date dateutilisateurquestionquiz, int idquestionquiz, long idutilisateur) {
        this.dateutilisateurquestionquiz = dateutilisateurquestionquiz;
        this.idquestionquiz = idquestionquiz;
        this.idutilisateur = idutilisateur;
    }

    public Date getDateutilisateurquestionquiz() {
        return dateutilisateurquestionquiz;
    }

    public void setDateutilisateurquestionquiz(Date dateutilisateurquestionquiz) {
        this.dateutilisateurquestionquiz = dateutilisateurquestionquiz;
    }

    public int getIdquestionquiz() {
        return idquestionquiz;
    }

    public void setIdquestionquiz(int idquestionquiz) {
        this.idquestionquiz = idquestionquiz;
    }

    public long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
}
