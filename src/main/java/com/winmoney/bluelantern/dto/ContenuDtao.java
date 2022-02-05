package com.winmoney.bluelantern.dto;

public class ContenuDtao {
    private String libellecontenu;
    private String descriptioncontenu;
    private String documentcontenu;
    private int idcours;

    public ContenuDtao() {
    }

    public ContenuDtao(String libellecontenu, String descriptioncontenu, String documentcontenu, int idcours) {
        this.libellecontenu = libellecontenu;
        this.descriptioncontenu = descriptioncontenu;
        this.documentcontenu = documentcontenu;
        this.idcours = idcours;
    }

    public String getLibellecontenu() {
        return libellecontenu;
    }

    public void setLibellecontenu(String libellecontenu) {
        this.libellecontenu = libellecontenu;
    }

    public String getDescriptioncontenu() {
        return descriptioncontenu;
    }

    public void setDescriptioncontenu(String descriptioncontenu) {
        this.descriptioncontenu = descriptioncontenu;
    }

    public String getDocumentcontenu() {
        return documentcontenu;
    }

    public void setDocumentcontenu(String documentcontenu) {
        this.documentcontenu = documentcontenu;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }
}
