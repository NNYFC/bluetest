package com.winmoney.bluelantern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "anneeacademique")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Anneeacademique.findAll", query = "SELECT a FROM Anneeacademique a")
        , @NamedQuery(name = "Anneeacademique.findByIdanneeacademique", query = "SELECT a FROM Anneeacademique a WHERE a.idanneeacademique = :idanneeacademique")
        , @NamedQuery(name = "Anneeacademique.findByLibelleanneeacademique", query = "SELECT a FROM Anneeacademique a WHERE a.libelleanneeacademique = :libelleanneeacademique")
})
public class Anneeacademique {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idanneeacademique")
    private Integer idanneeacademique;
    @Column(name = "libelleanneeacademique")
    private String libelleanneeacademique;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idanneeacademique",fetch = FetchType.LAZY)
    private Collection<Utilisateuranneeacademique> utilisateuranneeacademiqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idanneeacademique")
    private Collection<Cours> coursCollection;

    public Anneeacademique() {
    }

    public Anneeacademique(String libelleanneeacademique) {
        this.libelleanneeacademique = libelleanneeacademique;
    }

    public Anneeacademique(String libelleanneeacademique, Collection<Utilisateuranneeacademique> utilisateuranneeacademiqueCollection, Collection<Cours> coursCollection) {
        this.libelleanneeacademique = libelleanneeacademique;
        this.utilisateuranneeacademiqueCollection = utilisateuranneeacademiqueCollection;
        this.coursCollection = coursCollection;
    }

    public Integer getIdanneeacademique() {
        return idanneeacademique;
    }

    public void setIdanneeacademique(Integer idanneeacademique) {
        this.idanneeacademique = idanneeacademique;
    }

    public String getLibelleanneeacademique() {
        return libelleanneeacademique;
    }

    public void setLibelleanneeacademique(String libelleanneeacademique) {
        this.libelleanneeacademique = libelleanneeacademique;
    }

    public Collection<Utilisateuranneeacademique> getUtilisateuranneeacademiqueCollection() {
        return utilisateuranneeacademiqueCollection;
    }

    public void setUtilisateuranneeacademiqueCollection(Collection<Utilisateuranneeacademique> utilisateuranneeacademiqueCollection) {
        this.utilisateuranneeacademiqueCollection = utilisateuranneeacademiqueCollection;
    }

    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }
}
