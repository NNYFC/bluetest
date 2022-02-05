package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "filiere")
public class Filiere {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfiliere")
    private Long idfiliere;

    @Column(name = "libellefiliere")
    private String libellefiliere;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfiliere",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Niveaufiliere> niveaufiliereCollection;

    public Filiere() {
    }

    public Filiere(String libellefiliere) {
        this.libellefiliere = libellefiliere;
    }

    public Filiere(String libellefiliere, Collection<Niveaufiliere> niveaufiliereCollection) {
        this.libellefiliere = libellefiliere;
        this.niveaufiliereCollection= niveaufiliereCollection;
    }

    public Long getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Long idfiliere) {
        this.idfiliere = idfiliere;
    }

    public String getLibellefiliere() {
        return libellefiliere;
    }

    public void setLibellefiliere(String libellefiliere) {
        this.libellefiliere = libellefiliere;
    }

    public Collection<Niveaufiliere> getNiveaufiliereCollection() {
        return niveaufiliereCollection;
    }

    public void setNiveaufiliereCollection(Collection<Niveaufiliere> niveaufiliereCollection) {
        this.niveaufiliereCollection = niveaufiliereCollection;
    }
}
