package com.winmoney.bluelantern.model;


import javax.persistence.*;

@Entity
@Table(name = "utilisateuranneeacademique")
@NamedQueries({
        @NamedQuery(name = "Utilisateuranneeacademique.findAll", query = "SELECT DISTINCT u FROM Utilisateuranneeacademique u")
        , @NamedQuery(name = "Utilisateuranneeacademique.findByIdutilisateuranneeacademique", query = "SELECT u FROM Utilisateuranneeacademique u WHERE u.idutilisateuranneeacademique = :idutilisateuranneeacademique")
})
public class Utilisateuranneeacademique {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateuranneeacademique")
    private Integer idutilisateuranneeacademique;

    @JoinColumn(name = "idanneeacademique", referencedColumnName = "idanneeacademique")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Anneeacademique idanneeacademique;

    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    @JoinColumn(name = "idniveaufiliere", referencedColumnName = "idniveaufiliere")
    @ManyToOne(optional = false)
    private Niveaufiliere idniveaufiliere;

    public Utilisateuranneeacademique() {
    }

    public Utilisateuranneeacademique(Anneeacademique idanneeacademique, Utilisateur idutilisateur, Niveaufiliere idniveaufiliere) {
        this.idanneeacademique = idanneeacademique;
        this.idutilisateur = idutilisateur;
        this.idniveaufiliere = idniveaufiliere;
    }

    public Integer getIdutilisateuranneeacademique() {
        return idutilisateuranneeacademique;
    }

    public void setIdutilisateuranneeacademique(Integer idutilisateuranneeacademique) {
        this.idutilisateuranneeacademique = idutilisateuranneeacademique;
    }

    public Anneeacademique getIdanneeacademique() {
        return idanneeacademique;
    }

    public void setIdanneeacademique(Anneeacademique idanneeacademique) {
        this.idanneeacademique = idanneeacademique;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Niveaufiliere getIdniveaufiliere() {
        return idniveaufiliere;
    }

    public void setIdniveaufiliere(Niveaufiliere idniveaufiliere) {
        this.idniveaufiliere = idniveaufiliere;
    }
}
