package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

//@NamedQuery(name = "Questionquiz.findQuestionquizByIdquiz", query = "SELECT i.idquiz,q.idquestionquiz,q.libellequestionquiz,r.idreponsequiz,r.libellereponsequiz,r.bonreponsequiz FROM Quiz i left join Questionquiz q  on q.idquiz=i.idquiz left JOIN Reponsequiz r ON q.idquestionquiz = r.idquestionquiz WHERE q.idquiz = :idquiz")

@Entity
@Table(name = "questionquiz")
@NamedQueries({
        @NamedQuery(name = "Questionquiz.findAll", query = "SELECT q FROM Questionquiz q")
        , @NamedQuery(name = "Questionquiz.findByIdquestionquiz", query = "SELECT q FROM Questionquiz q WHERE q.idquestionquiz = :idquestionquiz")
        , @NamedQuery(name = "Questionquiz.findByLibellequestionquiz", query = "SELECT q FROM Questionquiz q WHERE q.libellequestionquiz = :libellequestionquiz")
})
@NamedNativeQuery(
        name = "Questionquiz.findAllQuestionsByQuiyId",
        query = "SELECT DISTINCT * FROM Questionquiz q WHERE q.idquiz = :idquiz",
        resultClass = Questionquiz.class
)
public class Questionquiz {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquestionquiz")
    private Integer idquestionquiz;

    @Column(name = "libellequestionquiz")
    private String libellequestionquiz;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquestionquiz",fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Reponsequiz> reponsequizCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateurquestionquiz",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Utilisateurquestionquiz> utilisateurquestionquizCollection;

    @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Quiz idquiz;

    public Questionquiz() {
    }

    public Questionquiz(String libellequestionquiz) {
        this.libellequestionquiz = libellequestionquiz;
    }

    public Questionquiz(String libellequestionquiz, Collection<Reponsequiz> reponsequizCollection, Collection<Utilisateurquestionquiz> utilisateurquestionquizCollection, Quiz idquiz) {
        this.libellequestionquiz = libellequestionquiz;
        this.reponsequizCollection = reponsequizCollection;
        this.utilisateurquestionquizCollection = utilisateurquestionquizCollection;
        this.idquiz = idquiz;
    }

    public Integer getIdquestionquiz() {
        return idquestionquiz;
    }

    public void setIdquestionquiz(Integer idquestionquiz) {
        this.idquestionquiz = idquestionquiz;
    }

    public String getLibellequestionquiz() {
        return libellequestionquiz;
    }

    public void setLibellequestionquiz(String libellequestionquiz) {
        this.libellequestionquiz = libellequestionquiz;
    }

    public Collection<Reponsequiz> getReponsequizCollection() {
        return reponsequizCollection;
    }

    public void setReponsequizCollection(Collection<Reponsequiz> reponsequizCollection) {
        this.reponsequizCollection = reponsequizCollection;
    }

    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }

    public Collection<Utilisateurquestionquiz> getUtilisateurquestionquizCollection() {
        return utilisateurquestionquizCollection;
    }

    public void setUtilisateurquestionquizCollection(Collection<Utilisateurquestionquiz> utilisateurquestionquizCollection) {
        this.utilisateurquestionquizCollection = utilisateurquestionquizCollection;
    }
}
