package com.winmoney.bluelantern.dto;

public class ReponsequizDtao {
    private String libellereponsequiz;
    private Boolean bonreponsequiz;
    private int idquestionquiz;

    public ReponsequizDtao() {
    }

    public ReponsequizDtao(String libellereponsequiz, Boolean bonreponsequiz, int idquestionquiz) {
        this.libellereponsequiz = libellereponsequiz;
        this.bonreponsequiz = bonreponsequiz;
        this.idquestionquiz = idquestionquiz;
    }

    public String getLibellereponsequiz() {
        return libellereponsequiz;
    }

    public void setLibellereponsequiz(String libellereponsequiz) {
        this.libellereponsequiz = libellereponsequiz;
    }

    public Boolean getBonreponsequiz() {
        return bonreponsequiz;
    }

    public void setBonreponsequiz(Boolean bonreponsequiz) {
        this.bonreponsequiz = bonreponsequiz;
    }

    public int getIdquestionquiz() {
        return idquestionquiz;
    }

    public void setIdquestionquiz(int idquestionquiz) {
        this.idquestionquiz = idquestionquiz;
    }
}
