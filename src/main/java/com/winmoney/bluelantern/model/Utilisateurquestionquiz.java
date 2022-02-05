package com.winmoney.bluelantern.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utilisateurquestionquiz")
@NamedNativeQuery(
        name = "Utilisateurquestionquiz.findUserlastQuestionquiz",
        query = "SELECT s.idutilisateurquestionquiz,s.dateutilisateurquestionquiz,u.idutilisateur,\n" +
                "u.nomutilisateur,u.emailutilisateur,u.pseudoutilisateur,u.roleutilisateur,\n" +
                "q.idquestionquiz,q.libellequestionquiz,f.idquiz,f.libellequiz\n" +
                "FROM Utilisateurquestionquiz s\n" +
                "JOIN Utilisateur u ON s.idutilisateur = u.idutilisateur\n" +
                "JOIN Questionquiz q ON s.idquestionquiz = q.idquestionquiz\n" +
                "JOIN Quiz f ON q.idquiz = f.idquiz\n" +
                "WHERE u.idutilisateur = :idutilisateur AND f.idquiz = :idquiz",
        resultClass = Utilisateurquestionquiz.class
)
public class Utilisateurquestionquiz {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateurquestionquiz")
    private Integer idutilisateurquestionquiz;

    @Column(name = "dateutilisateurquestionquiz")
    private Date dateutilisateurquestionquiz;

    @JoinColumn(name = "idquestionquiz", referencedColumnName = "idquestionquiz")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Questionquiz idquestionquiz;

    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateur idutilisateur;

    public Utilisateurquestionquiz() {
    }

    public Utilisateurquestionquiz(Date dateutilisateurquestionquiz, Questionquiz idquestionquiz, Utilisateur idutilisateur) {
        this.dateutilisateurquestionquiz = dateutilisateurquestionquiz;
        this.idquestionquiz = idquestionquiz;
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdutilisateurquestionquiz() {
        return idutilisateurquestionquiz;
    }

    public void setIdutilisateurquestionquiz(Integer idutilisateurquestionquiz) {
        this.idutilisateurquestionquiz = idutilisateurquestionquiz;
    }

    public Date getDateutilisateurquestionquiz() {
        return dateutilisateurquestionquiz;
    }

    public void setDateutilisateurquestionquiz(Date dateutilisateurquestionquiz) {
        this.dateutilisateurquestionquiz = dateutilisateurquestionquiz;
    }

    public Questionquiz getIdquestionquiz() {
        return idquestionquiz;
    }

    public void setIdquestionquiz(Questionquiz idquestionquiz) {
        this.idquestionquiz = idquestionquiz;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
}
