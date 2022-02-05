package com.winmoney.bluelantern.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "scoreepreuve")
@NamedQueries({
        @NamedQuery(name = "Scoreepreuve.findAll", query = "SELECT s FROM Scoreepreuve s")
        , @NamedQuery(name = "Scoreepreuve.findByIdscoreepreuve", query = "SELECT s FROM Scoreepreuve s WHERE s.idscoreepreuve = :idscoreepreuve")
        , @NamedQuery(name = "Scoreepreuve.findByLibellescoreepreuve", query = "SELECT s FROM Scoreepreuve s WHERE s.libellescoreepreuve = :libellescoreepreuve")
        , @NamedQuery(name = "Scoreepreuve.findByDatescoreepreuve", query = "SELECT s FROM Scoreepreuve s WHERE s.datescoreepreuve = :datescoreepreuve")
})
@NamedNativeQuery(
        name = "Scoreepreuve.findUserScoreById",
        query = "SELECT s.idscoreepreuve,s.notescoreepreuve,s.datescoreepreuve,q.idepreuve,q.libelleepreuve,u.idutilisateur,u.nomutilisateur,u.emailutilisateur,\n" +
                "u.pseudoutilisateur,u.motdepasseutilisateur,u.roleutilisateur \n" +
                "FROM Scoreepreuve s\n" +
                "JOIN Epreuve q ON s.idepreuve = q.idepreuve \n" +
                "right JOIN Utilisateur u ON s.idutilisateur = u.idutilisateur \n" +
                "WHERE u.idutilisateur = :idutilisateur",
        resultClass = Scoreepreuve.class
)
public class Scoreepreuve {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idscoreepreuve")
    private Integer idscoreepreuve;

    @Column(name = "libellescoreepreuve")
    private Integer libellescoreepreuve;

    @Column(name = "datescoreepreuve")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date datescoreepreuve;

    @JoinColumn(name = "idepreuve", referencedColumnName = "idepreuve")
    @ManyToOne(optional = false)
    private Epreuve idepreuve;

    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Scoreepreuve() {
    }

    public Scoreepreuve(Integer libellescoreepreuve, Date datescoreepreuve) {
        this.libellescoreepreuve = libellescoreepreuve;
        this.datescoreepreuve = datescoreepreuve;
    }

    public Scoreepreuve(Integer libellescoreepreuve, Date datescoreepreuve, Epreuve idepreuve, Utilisateur idutilisateur) {
        this.libellescoreepreuve = libellescoreepreuve;
        this.datescoreepreuve = datescoreepreuve;
        this.idepreuve = idepreuve;
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdscoreepreuve() {
        return idscoreepreuve;
    }

    public void setIdscoreepreuve(Integer idscoreepreuve) {
        this.idscoreepreuve = idscoreepreuve;
    }

    public Integer getLibellescoreepreuve() {
        return libellescoreepreuve;
    }

    public void setLibellescoreepreuve(Integer libellescoreepreuve) {
        this.libellescoreepreuve = libellescoreepreuve;
    }

    public Date getDatescoreepreuve() {
        return datescoreepreuve;
    }

    public void setDatescoreepreuve(Date datescoreepreuve) {
        this.datescoreepreuve = datescoreepreuve;
    }

    public Epreuve getIdepreuve() {
        return idepreuve;
    }

    public void setIdepreuve(Epreuve idepreuve) {
        this.idepreuve = idepreuve;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
}
