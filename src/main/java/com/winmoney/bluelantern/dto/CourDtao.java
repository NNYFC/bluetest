package com.winmoney.bluelantern.dto;

public class CourDtao {
    private String libellecours;
    private String nombreheurecours;
    private int idanneeacademique;

    public CourDtao() {
    }

    public CourDtao(String libellecours, String nombreheurecours, int idanneeacademique) {
        this.libellecours = libellecours;
        this.nombreheurecours = nombreheurecours;
        this.idanneeacademique = idanneeacademique;
    }

    public String getLibellecours() {
        return libellecours;
    }

    public void setLibellecours(String libellecours) {
        this.libellecours = libellecours;
    }

    public String getNombreheurecours() {
        return nombreheurecours;
    }

    public void setNombreheurecours(String nombreheurecours) {
        this.nombreheurecours = nombreheurecours;
    }

    public int getIdanneeacademique() {
        return idanneeacademique;
    }

    public void setIdanneeacademique(int idanneeacademique) {
        this.idanneeacademique = idanneeacademique;
    }
}
