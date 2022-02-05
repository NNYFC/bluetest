package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "questionepreuve")
@NamedQueries({
        @NamedQuery(name = "Questionepreuve.findAll", query = "SELECT q FROM Questionepreuve q")
        , @NamedQuery(name = "Questionepreuve.findByIdquestionepreuve", query = "SELECT q FROM Questionepreuve q WHERE q.idquestionepreuve = :idquestionepreuve")
        , @NamedQuery(name = "Questionepreuve.findByLibellequestionepreuve", query = "SELECT q FROM Questionepreuve q WHERE q.libellequestionepreuve = :libellequestionepreuve")
})
@NamedNativeQuery(
        name = "Questionepreuve.findAllQuestionsByEpreuveId",
        query = "SELECT DISTINCT * FROM Questionepreuve q WHERE q.idepreuve = :idepreuve",
        resultClass = Questionepreuve.class
)
public class Questionepreuve {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquestionepreuve")
    private Integer idquestionepreuve;
    @Column(name = "libellequestionepreuve")
    private String libellequestionepreuve;

    @JoinColumn(name = "idepreuve", referencedColumnName = "idepreuve")
    @ManyToOne(optional = false)
    private Epreuve idepreuve;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquestionepreuve")
    @JsonIgnore
    private Collection<Reponseepreuve> reponseepreuveCollection;

    public Questionepreuve() {
    }

    public Questionepreuve(String libellequestionepreuve, Epreuve idepreuve) {
        this.libellequestionepreuve = libellequestionepreuve;
        this.idepreuve = idepreuve;
    }

    public Questionepreuve(String libellequestionepreuve, Epreuve idepreuve, Collection<Reponseepreuve> reponseepreuveCollection) {
        this.libellequestionepreuve = libellequestionepreuve;
        this.idepreuve = idepreuve;
        this.reponseepreuveCollection = reponseepreuveCollection;
    }

    public Integer getIdquestionepreuve() {
        return idquestionepreuve;
    }

    public void setIdquestionepreuve(Integer idquestionepreuve) {
        this.idquestionepreuve = idquestionepreuve;
    }

    public String getLibellequestionepreuve() {
        return libellequestionepreuve;
    }

    public void setLibellequestionepreuve(String libellequestionepreuve) {
        this.libellequestionepreuve = libellequestionepreuve;
    }

    public Epreuve getIdepreuve() {
        return idepreuve;
    }

    public void setIdepreuve(Epreuve idepreuve) {
        this.idepreuve = idepreuve;
    }

    public Collection<Reponseepreuve> getReponseepreuveCollection() {
        return reponseepreuveCollection;
    }

    public void setReponseepreuveCollection(Collection<Reponseepreuve> reponseepreuveCollection) {
        this.reponseepreuveCollection = reponseepreuveCollection;
    }
}
