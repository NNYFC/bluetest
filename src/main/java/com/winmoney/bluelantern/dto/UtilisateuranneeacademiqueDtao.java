package com.winmoney.bluelantern.dto;

public class UtilisateuranneeacademiqueDtao {
    private int idanneeacademique;
    private long idutilisateur;
    private long idniveaufiliere;

    public UtilisateuranneeacademiqueDtao() {
    }

    public UtilisateuranneeacademiqueDtao(int idanneeacademique, long idutilisateur, long idniveaufiliere) {
        this.idanneeacademique = idanneeacademique;
        this.idutilisateur = idutilisateur;
        this.idniveaufiliere = idniveaufiliere;
    }

    public int getIdanneeacademique() {
        return idanneeacademique;
    }

    public void setIdanneeacademique(int idanneeacademique) {
        this.idanneeacademique = idanneeacademique;
    }

    public long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public long getIdniveaufiliere() {
        return idniveaufiliere;
    }

    public void setIdniveaufiliere(long idniveaufiliere) {
        this.idniveaufiliere = idniveaufiliere;
    }
}
