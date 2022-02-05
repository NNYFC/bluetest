package com.winmoney.bluelantern.dto;

public class UserDtao {
    private String nomutilisateur;
    private String emailutilisateur;
    private String pseudoutilisateur;
    private String motdepasseutilisateur;
    private String roleutilisateur;

    public UserDtao() {
    }

    public UserDtao(String emailutilisateur, String motdepasseutilisateur) {
        this.emailutilisateur = emailutilisateur;
        this.motdepasseutilisateur = motdepasseutilisateur;
    }

    public UserDtao(String nomutilisateur, String emailutilisateur, String pseudoutilisateur, String motdepasseutilisateur) {
        this.nomutilisateur = nomutilisateur;
        this.emailutilisateur = emailutilisateur;
        this.pseudoutilisateur = pseudoutilisateur;
        this.motdepasseutilisateur = motdepasseutilisateur;
    }

    public UserDtao(String nomutilisateur, String emailutilisateur, String pseudoutilisateur, String motdepasseutilisateur, String roleutilisateur) {
        this.nomutilisateur = nomutilisateur;
        this.emailutilisateur = emailutilisateur;
        this.pseudoutilisateur = pseudoutilisateur;
        this.motdepasseutilisateur = motdepasseutilisateur;
        this.roleutilisateur = roleutilisateur;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getEmailutilisateur() {
        return emailutilisateur;
    }

    public void setEmailutilisateur(String emailutilisateur) {
        this.emailutilisateur = emailutilisateur;
    }

    public String getPseudoutilisateur() {
        return pseudoutilisateur;
    }

    public void setPseudoutilisateur(String pseudoutilisateur) {
        this.pseudoutilisateur = pseudoutilisateur;
    }

    public String getMotdepasseutilisateur() {
        return motdepasseutilisateur;
    }

    public void setMotdepasseutilisateur(String motdepasseutilisateur) {
        this.motdepasseutilisateur = motdepasseutilisateur;
    }

    public String getRoleutilisateur() {
        return roleutilisateur;
    }

    public void setRoleutilisateur(String roleutilisateur) {
        this.roleutilisateur = roleutilisateur;
    }

}
