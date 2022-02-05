package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "scorequiz")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Scorequiz.findAll", query = "SELECT s FROM Scorequiz s")
        , @NamedQuery(name = "Scorequiz.findByIdscorequiz", query = "SELECT s FROM Scorequiz s WHERE s.idscorequiz = :idscorequiz")
        , @NamedQuery(name = "Scorequiz.findByNotescorequiz", query = "SELECT s FROM Scorequiz s WHERE s.notescorequiz = :notescorequiz")
        , @NamedQuery(name = "Scorequiz.findByDatescorequiz", query = "SELECT s FROM Scorequiz s WHERE s.datescorequiz = :datescorequiz")
})
@NamedNativeQuery(
        name = "Scorequiz.findUserScoreById",
        query = "SELECT s.idscorequiz,s.notescorequiz,s.datescorequiz,q.idquiz,q.libellequiz,u.idutilisateur,u.nomutilisateur,u.emailutilisateur,\n" +
                "u.pseudoutilisateur,u.motdepasseutilisateur,u.roleutilisateur \n" +
                "FROM Scorequiz s\n" +
                "JOIN Quiz q ON s.idquiz = q.idquiz \n" +
                "right JOIN Utilisateur u ON s.idutilisateur = u.idutilisateur \n" +
                "WHERE u.idutilisateur = :idutilisateur",
        resultClass = Scorequiz.class
)
public class Scorequiz {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idscorequiz")
    private Integer idscorequiz;

    @Column(name = "notescorequiz")
    private Integer notescorequiz;

    @Column(name = "datescorequiz")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date datescorequiz;

    @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Quiz idquiz;

    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateur idutilisateur;

    public Scorequiz() {
    }

    public Scorequiz(Integer notescorequiz, Date datescorequiz) {
        this.notescorequiz = notescorequiz;
        this.datescorequiz = datescorequiz;
    }

    public Scorequiz(Integer notescorequiz, Date datescorequiz, Quiz idquiz, Utilisateur idutilisateur) {
        this.notescorequiz = notescorequiz;
        this.datescorequiz = datescorequiz;
        this.idquiz = idquiz;
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdscorequiz() {
        return idscorequiz;
    }

    public void setIdscorequiz(Integer idscorequiz) {
        this.idscorequiz = idscorequiz;
    }

    public Integer getNotescorequiz() {
        return notescorequiz;
    }

    public void setNotescorequiz(Integer notescorequiz) {
        this.notescorequiz = notescorequiz;
    }

    public Date getDatescorequiz() {
        return datescorequiz;
    }

    public void setDatescorequiz(Date datescorequiz) {
        this.datescorequiz = datescorequiz;
    }

    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
}
