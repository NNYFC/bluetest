package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
        , @NamedQuery(name = "Quiz.findByLibellequiz", query = "SELECT q FROM Quiz q WHERE q.libellequiz = :libellequiz")
})
public class Quiz {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquiz")
    private Integer idquiz;

    @Column(name = "libellequiz")
    private String libellequiz;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquiz",fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Questionquiz> questionquizCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquiz")
    @JsonIgnore
    private Collection<Scorequiz> scorequizCollection;

    public Quiz() {
    }

    public Quiz(String libellequiz) {
        this.libellequiz = libellequiz;
    }

    public Quiz(String libellequiz, Collection<Questionquiz> questionquizCollection, Collection<Scorequiz> scorequizCollection) {
        this.libellequiz = libellequiz;
        this.questionquizCollection = questionquizCollection;
        this.scorequizCollection = scorequizCollection;
    }

    public Integer getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public String getLibellequiz() {
        return libellequiz;
    }

    public void setLibellequiz(String libellequiz) {
        this.libellequiz = libellequiz;
    }

    public Collection<Questionquiz> getQuestionquizCollection() {
        return questionquizCollection;
    }

    public void setQuestionquizCollection(Collection<Questionquiz> questionquizCollection) {
        this.questionquizCollection = questionquizCollection;
    }

    public Collection<Scorequiz> getScorequizCollection() {
        return scorequizCollection;
    }

    public void setScorequizCollection(Collection<Scorequiz> scorequizCollection) {
        this.scorequizCollection = scorequizCollection;
    }
}
