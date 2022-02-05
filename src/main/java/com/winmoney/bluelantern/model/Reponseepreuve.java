package com.winmoney.bluelantern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "reponseepreuve")
@NamedQueries({
        @NamedQuery(name = "Reponseepreuve.findAll", query = "SELECT r FROM Reponseepreuve r")
        , @NamedQuery(name = "Reponseepreuve.findByIdreponseepreuve", query = "SELECT r FROM Reponseepreuve r WHERE r.idreponseepreuve = :idreponseepreuve")
        , @NamedQuery(name = "Reponseepreuve.findByLibellereponseepreuve", query = "SELECT r FROM Reponseepreuve r WHERE r.libellereponseepreuve = :libellereponseepreuve")
        , @NamedQuery(name = "Reponseepreuve.findByBonreponseepreuve", query = "SELECT r FROM Reponseepreuve r WHERE r.bonreponseepreuve = :bonreponseepreuve")
})
@NamedNativeQuery(
        name = "Reponseepreuve.findAllReponsequizByQuestionId",
        query = "SELECT DISTINCT * FROM Reponseepreuve q WHERE q.idquestionepreuve= :idquestionepreuve",
        resultClass = Reponseepreuve.class
)
public class Reponseepreuve {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreponseepreuve")
    private Integer idreponseepreuve;
    @Column(name = "libellereponseepreuve")
    private String libellereponseepreuve;
    @Column(name = "bonreponseepreuve")
    private Boolean bonreponseepreuve;

    @JoinColumn(name = "idquestionepreuve", referencedColumnName = "idquestionepreuve")
    @ManyToOne(optional = false)
    private Questionepreuve idquestionepreuve;

    public Reponseepreuve() {
    }

    public Reponseepreuve(String libellereponseepreuve, Boolean bonreponseepreuve) {
        this.libellereponseepreuve = libellereponseepreuve;
        this.bonreponseepreuve = bonreponseepreuve;
    }

    public Reponseepreuve(String libellereponseepreuve, Boolean bonreponseepreuve, Questionepreuve idquestionepreuve) {
        this.libellereponseepreuve = libellereponseepreuve;
        this.bonreponseepreuve = bonreponseepreuve;
        this.idquestionepreuve = idquestionepreuve;
    }

    public Integer getIdreponseepreuve() {
        return idreponseepreuve;
    }

    public void setIdreponseepreuve(Integer idreponseepreuve) {
        this.idreponseepreuve = idreponseepreuve;
    }

    public String getLibellereponseepreuve() {
        return libellereponseepreuve;
    }

    public void setLibellereponseepreuve(String libellereponseepreuve) {
        this.libellereponseepreuve = libellereponseepreuve;
    }

    public Boolean getBonreponseepreuve() {
        return bonreponseepreuve;
    }

    public void setBonreponseepreuve(Boolean bonreponseepreuve) {
        this.bonreponseepreuve = bonreponseepreuve;
    }

    public Questionepreuve getIdquestionepreuve() {
        return idquestionepreuve;
    }

    public void setIdquestionepreuve(Questionepreuve idquestionepreuve) {
        this.idquestionepreuve = idquestionepreuve;
    }
}
