package com.winmoney.bluelantern.dto;

import java.util.Date;

public class ScoreDtao {
    private int libellescore;
    private Date datescorequiz;
    private long idutilisateur;
    private int idquiz;

    public ScoreDtao() {
    }

    public ScoreDtao(int libellescore, Date datescorequiz, long idutilisateur, int idquiz) {
        this.libellescore = libellescore;
        this.datescorequiz = datescorequiz;
        this.idutilisateur = idutilisateur;
        this.idquiz = idquiz;
    }

    public int getLibellescore() {
        return libellescore;
    }

    public void setLibellescore(int libellescore) {
        this.libellescore = libellescore;
    }

    public Date getDatescorequiz() {
        return datescorequiz;
    }

    public void setDatescorequiz(Date datescorequiz) {
        this.datescorequiz = datescorequiz;
    }

    public long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(int idquiz) {
        this.idquiz = idquiz;
    }
}
