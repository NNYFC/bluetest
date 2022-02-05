package com.winmoney.bluelantern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "reponsequiz")
@NamedQueries({
        @NamedQuery(name = "Reponsequiz.findAll", query = "SELECT r FROM Reponsequiz r")
        , @NamedQuery(name = "Reponsequiz.findByIdreponsequiz", query = "SELECT r FROM Reponsequiz r WHERE r.idreponsequiz = :idreponsequiz")
        , @NamedQuery(name = "Reponsequiz.findByLibellereponsequiz", query = "SELECT r FROM Reponsequiz r WHERE r.libellereponsequiz = :libellereponsequiz")
        , @NamedQuery(name = "Reponsequiz.findByBonreponsequiz", query = "SELECT r FROM Reponsequiz r WHERE r.bonreponsequiz = :bonreponsequiz")
})
@NamedNativeQuery(
        name = "Reponsequiz.findAllReponsequizByQuestionId",
        query = "SELECT * FROM Reponsequiz WHERE Reponsequiz.idquestionquiz = :idquestionquiz",
        resultClass = Reponsequiz.class
)
public class Reponsequiz {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreponsequiz")
    private Integer idreponsequiz;
    @Column(name = "libellereponsequiz")
    private String libellereponsequiz;
    @Column(name = "bonreponsequiz")
    private Boolean bonreponsequiz;

    @JoinColumn(name = "idquestionquiz", referencedColumnName = "idquestionquiz")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Questionquiz idquestionquiz;

    public Reponsequiz() {
    }

    public Reponsequiz(String libellereponsequiz, Boolean bonreponsequiz) {
        this.libellereponsequiz = libellereponsequiz;
        this.bonreponsequiz = bonreponsequiz;
    }

    public Reponsequiz(String libellereponsequiz, Boolean bonreponsequiz, Questionquiz idquestionquiz) {
        this.libellereponsequiz = libellereponsequiz;
        this.bonreponsequiz = bonreponsequiz;
        this.idquestionquiz = idquestionquiz;
    }

    public Integer getIdreponsequiz() {
        return idreponsequiz;
    }

    public void setIdreponsequiz(Integer idreponsequiz) {
        this.idreponsequiz = idreponsequiz;
    }

    public String getLibellereponsequiz() {
        return libellereponsequiz;
    }

    public void setLibellereponsequiz(String libellereponsequiz) {
        this.libellereponsequiz = libellereponsequiz;
    }

    public Boolean getBonreponsequiz() {
        return bonreponsequiz;
    }

    public void setBonreponsequiz(Boolean bonreponsequiz) {
        this.bonreponsequiz = bonreponsequiz;
    }

    public Questionquiz getIdquestionquiz() {
        return idquestionquiz;
    }

    public void setIdquestionquiz(Questionquiz idquestionquiz) {
        this.idquestionquiz = idquestionquiz;
    }
}
