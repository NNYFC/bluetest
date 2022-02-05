package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "niveau")
public class Niveau {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idniveau")
    private Long idniveau;

    @Column(name = "libelleniveau")
    private Integer libelleniveau;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idniveau",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Niveaufiliere> niveaufiliereCollection;



    public Niveau() {
    }

    public Niveau(Integer libelleniveau) {
        this.libelleniveau = libelleniveau;
    }

    public Niveau(Collection<Niveaufiliere> niveaufiliereCollection, Integer libelleniveau) {
        this.niveaufiliereCollection = niveaufiliereCollection;
        this.libelleniveau = libelleniveau;
    }

    public Long getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Long idniveau) {
        this.idniveau = idniveau;
    }

    public Integer getLibelleniveau() {
        return libelleniveau;
    }

    public void setLibelleniveau(Integer libelleniveau) {
        this.libelleniveau = libelleniveau;
    }

    public Collection<Niveaufiliere> getNiveaufiliereCollection() {
        return niveaufiliereCollection;
    }

    public void setNiveaufiliereCollection(Collection<Niveaufiliere> niveaufiliereCollection) {
        this.niveaufiliereCollection = niveaufiliereCollection;
    }
}
