package com.winmoney.bluelantern.dto;

public class QuestionepreuveDtao {
    private String libellequestionepreuve;
    private int idepreuve;

    public QuestionepreuveDtao() {
    }

    public QuestionepreuveDtao(String libellequestionepreuve, int idepreuve) {
        this.libellequestionepreuve = libellequestionepreuve;
        this.idepreuve = idepreuve;
    }

    public String getLibellequestionepreuve() {
        return libellequestionepreuve;
    }

    public void setLibellequestionepreuve(String libellequestionepreuve) {
        this.libellequestionepreuve = libellequestionepreuve;
    }

    public int getIdepreuve() {
        return idepreuve;
    }

    public void setIdepreuve(int idepreuve) {
        this.idepreuve = idepreuve;
    }
}
