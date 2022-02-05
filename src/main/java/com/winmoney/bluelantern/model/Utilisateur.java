package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "utilisateur")
@NamedNativeQuery(
        name = "Utilisateur.findByEmailutilisateur",
        query = "SELECT u.idutilisateur,u.nomutilisateur,u.emailutilisateur,u.pseudoutilisateur,u.motdepasseutilisateur,u.roleutilisateur FROM utilisateur u WHERE u.emailutilisateur = :emailutilisateur",
        resultClass = Utilisateur.class
)
public class Utilisateur {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private Long idutilisateur;

    @Column(name = "nomutilisateur")
    private String nomutilisateur;

    @Column(name = "emailutilisateur")
    private String emailutilisateur;

    @Column(name = "pseudoutilisateur")
    private String pseudoutilisateur;

    @Column(name = "motdepasseutilisateur")
    private String motdepasseutilisateur;

    @Column(name = "roleutilisateur")
    private String roleutilisateur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Scoreepreuve> scoreepreuveCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Utilisateuranneeacademique> utilisateuranneeacademiqueCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Scorequiz> scorequizCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateurquestionquiz",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Utilisateurquestionquiz> utilisateurquestionquizCollection;

    public Utilisateur() {
    }

    public Utilisateur(String nomutilisateur, String emailutilisateur, String pseudoutilisateur, String motdepasseutilisateur, String roleutilisateur) {
        this.nomutilisateur = nomutilisateur;
        this.emailutilisateur = emailutilisateur;
        this.pseudoutilisateur = pseudoutilisateur;
        this.motdepasseutilisateur = motdepasseutilisateur;
        this.roleutilisateur = roleutilisateur;
    }

    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
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

    public Collection<Scoreepreuve> getScoreepreuveCollection() {
        return scoreepreuveCollection;
    }

    public void setScoreepreuveCollection(Collection<Scoreepreuve> scoreepreuveCollection) {
        this.scoreepreuveCollection = scoreepreuveCollection;
    }

    public Collection<Utilisateuranneeacademique> getUtilisateuranneeacademiqueCollection() {
        return utilisateuranneeacademiqueCollection;
    }

    public void setUtilisateuranneeacademiqueCollection(Collection<Utilisateuranneeacademique> utilisateuranneeacademiqueCollection) {
        this.utilisateuranneeacademiqueCollection = utilisateuranneeacademiqueCollection;
    }

    public Collection<Scorequiz> getScorequizCollection() {
        return scorequizCollection;
    }

    public void setScorequizCollection(Collection<Scorequiz> scorequizCollection) {
        this.scorequizCollection = scorequizCollection;
    }

    public Collection<Utilisateurquestionquiz> getUtilisateurquestionquizCollection() {
        return utilisateurquestionquizCollection;
    }

    public void setUtilisateurquestionquizCollection(Collection<Utilisateurquestionquiz> utilisateurquestionquizCollection) {
        this.utilisateurquestionquizCollection = utilisateurquestionquizCollection;
    }
}
