package com.winmoney.bluelantern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c")
        , @NamedQuery(name = "Cours.findByIdcours", query = "SELECT c FROM Cours c WHERE c.idcours = :idcours")
        , @NamedQuery(name = "Cours.findByLibellecours", query = "SELECT c FROM Cours c WHERE c.libellecours = :libellecours")
        , @NamedQuery(name = "Cours.findByNombreheurecours", query = "SELECT c FROM Cours c WHERE c.nombreheurecours = :nombreheurecours")
})
@NamedNativeQuery(
        name = "Cours.findCoursByidAnneeacademique",
        query = "SELECT c FROM Cours c WHERE c.idanneeacademique = :idanneeacademique",
        resultClass = Cours.class
)
public class Cours {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcours")
    private Integer idcours;

    @Column(name = "libellecours")
    private String libellecours;

    @Column(name = "nombreheurecours")
    private String nombreheurecours;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcours")
    private Collection<Contenu> contenuCollection;

    @JoinColumn(name = "idanneeacademique", referencedColumnName = "idanneeacademique")
    @ManyToOne(optional = false)
    private Anneeacademique idanneeacademique;

    public Cours() {
    }

    public Cours(String libellecours, String nombreheurecours, Anneeacademique idanneeacademique) {
        this.libellecours = libellecours;
        this.nombreheurecours = nombreheurecours;
        this.idanneeacademique = idanneeacademique;
    }

    public Cours(String libellecours, String nombreheurecours, Collection<Contenu> contenuCollection, Anneeacademique idanneeacademique) {
        this.libellecours = libellecours;
        this.nombreheurecours = nombreheurecours;
        this.contenuCollection = contenuCollection;
        this.idanneeacademique = idanneeacademique;
    }

    public Integer getIdcours() {
        return idcours;
    }

    public void setIdcours(Integer idcours) {
        this.idcours = idcours;
    }

    public String getLibellecours() {
        return libellecours;
    }

    public void setLibellecours(String libellecours) {
        this.libellecours = libellecours;
    }

    public String getNombreheurecours() {
        return nombreheurecours;
    }

    public void setNombreheurecours(String nombreheurecours) {
        this.nombreheurecours = nombreheurecours;
    }

    public Collection<Contenu> getContenuCollection() {
        return contenuCollection;
    }

    public void setContenuCollection(Collection<Contenu> contenuCollection) {
        this.contenuCollection = contenuCollection;
    }

    public Anneeacademique getIdanneeacademique() {
        return idanneeacademique;
    }

    public void setIdanneeacademique(Anneeacademique idanneeacademique) {
        this.idanneeacademique = idanneeacademique;
    }
}
