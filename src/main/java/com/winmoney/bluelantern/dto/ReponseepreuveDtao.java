package com.winmoney.bluelantern.dto;

public class ReponseepreuveDtao {
    private String libellereponseepreuve;
    private Boolean bonreponseepreuve;
    private int idquestionepreuve;

    public ReponseepreuveDtao() {
    }

    public ReponseepreuveDtao(String libellereponseepreuve, Boolean bonreponseepreuve, int idquestionepreuve) {
        this.libellereponseepreuve = libellereponseepreuve;
        this.bonreponseepreuve = bonreponseepreuve;
        this.idquestionepreuve = idquestionepreuve;
    }

    public String getLibellereponseepreuve() {
        return libellereponseepreuve;
    }

    public void setLibellereponseepreuve(String libellereponseepreuve) {
        this.libellereponseepreuve = libellereponseepreuve;
    }

    public Boolean getBonreponseepreuve() {
        return bonreponseepreuve;
    }

    public void setBonreponseepreuve(Boolean bonreponseepreuve) {
        this.bonreponseepreuve = bonreponseepreuve;
    }

    public int getIdquestionepreuve() {
        return idquestionepreuve;
    }

    public void setIdquestionepreuve(int idquestionepreuve) {
        this.idquestionepreuve = idquestionepreuve;
    }
}
