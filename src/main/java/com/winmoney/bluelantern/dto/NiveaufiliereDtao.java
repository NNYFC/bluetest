package com.winmoney.bluelantern.dto;

public class NiveaufiliereDtao {
    private long idniveau;
    private long idfiliere;

    public NiveaufiliereDtao() {
    }

    public NiveaufiliereDtao(long idniveau, long idfiliere) {
        this.idniveau = idniveau;
        this.idfiliere = idfiliere;
    }

    public long getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(long idniveau) {
        this.idniveau = idniveau;
    }

    public long getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(long idfiliere) {
        this.idfiliere = idfiliere;
    }
}
