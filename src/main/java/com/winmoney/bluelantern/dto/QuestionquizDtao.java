package com.winmoney.bluelantern.dto;

public class QuestionquizDtao {
    private String libellequestionquiz;
    private int idquiz;

    public QuestionquizDtao() {
    }

    public QuestionquizDtao(String libellequestionquiz, int idquiz) {
        this.libellequestionquiz = libellequestionquiz;
        this.idquiz = idquiz;
    }

    public String getLibellequestionquiz() {
        return libellequestionquiz;
    }

    public void setLibellequestionquiz(String libellequestionquiz) {
        this.libellequestionquiz = libellequestionquiz;
    }

    public int getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(int idquiz) {
        this.idquiz = idquiz;
    }
}
