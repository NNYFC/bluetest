package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "epreuve")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Epreuve.findAll", query = "SELECT e FROM Epreuve e")
        , @NamedQuery(name = "Epreuve.findByIdepreuve", query = "SELECT e FROM Epreuve e WHERE e.idepreuve = :idepreuve")
        , @NamedQuery(name = "Epreuve.findByLibelleepreuve", query = "SELECT e FROM Epreuve e WHERE e.libelleepreuve = :libelleepreuve")
        , @NamedQuery(name = "Epreuve.findByDescriptionepreuve", query = "SELECT e FROM Epreuve e WHERE e.descriptionepreuve = :descriptionepreuve")
})
public class Epreuve {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepreuve")
    private Integer idepreuve;

    @Column(name = "libelleepreuve")
    private String libelleepreuve;

    @Column(name = "descriptionepreuve")
    private String descriptionepreuve;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idepreuve")
    private Collection<Scoreepreuve> scoreepreuveCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idepreuve")
    @JsonIgnore
    private Collection<Questionepreuve> questionepreuveCollection;

    public Epreuve() {
    }

    public Epreuve(String libelleepreuve, String descriptionepreuve) {
        this.libelleepreuve = libelleepreuve;
        this.descriptionepreuve = descriptionepreuve;
    }

    public Epreuve(String libelleepreuve, String descriptionepreuve, Collection<Scoreepreuve> scoreepreuveCollection, Collection<Questionepreuve> questionepreuveCollection) {
        this.libelleepreuve = libelleepreuve;
        this.descriptionepreuve = descriptionepreuve;
        this.scoreepreuveCollection = scoreepreuveCollection;
        this.questionepreuveCollection = questionepreuveCollection;
    }

    public Integer getIdepreuve() {
        return idepreuve;
    }

    public void setIdepreuve(Integer idepreuve) {
        this.idepreuve = idepreuve;
    }

    public String getLibelleepreuve() {
        return libelleepreuve;
    }

    public void setLibelleepreuve(String libelleepreuve) {
        this.libelleepreuve = libelleepreuve;
    }

    public String getDescriptionepreuve() {
        return descriptionepreuve;
    }

    public void setDescriptionepreuve(String descriptionepreuve) {
        this.descriptionepreuve = descriptionepreuve;
    }

    public Collection<Scoreepreuve> getScoreepreuveCollection() {
        return scoreepreuveCollection;
    }

    public void setScoreepreuveCollection(Collection<Scoreepreuve> scoreepreuveCollection) {
        this.scoreepreuveCollection = scoreepreuveCollection;
    }

    public Collection<Questionepreuve> getQuestionepreuveCollection() {
        return questionepreuveCollection;
    }

    public void setQuestionepreuveCollection(Collection<Questionepreuve> questionepreuveCollection) {
        this.questionepreuveCollection = questionepreuveCollection;
    }
}
