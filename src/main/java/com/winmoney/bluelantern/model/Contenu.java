package com.winmoney.bluelantern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contenu")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Contenu.findAll", query = "SELECT c FROM Contenu c")
        , @NamedQuery(name = "Contenu.findByIdcontenu", query = "SELECT c FROM Contenu c WHERE c.idcontenu = :idcontenu")
        , @NamedQuery(name = "Contenu.findByLibellecontenu", query = "SELECT c FROM Contenu c WHERE c.libellecontenu = :libellecontenu")
        , @NamedQuery(name = "Contenu.findByDescriptioncontenu", query = "SELECT c FROM Contenu c WHERE c.descriptioncontenu = :descriptioncontenu")
        , @NamedQuery(name = "Contenu.findByDocumentcontenu", query = "SELECT c FROM Contenu c WHERE c.documentcontenu = :documentcontenu")
})
@NamedNativeQuery(
        name = "Contenu.findAllByIdcours",
        query = "SELECT c FROM Contenu c WHERE c.idcours = :idcours",
        resultClass = Contenu.class
)
public class Contenu {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontenu")
    private Integer idcontenu;

    @Column(name = "libellecontenu")
    private String libellecontenu;

    @Column(name = "descriptioncontenu")
    private String descriptioncontenu;

    @Column(name = "documentcontenu")
    private String documentcontenu;

    @JoinColumn(name = "idcours", referencedColumnName = "idcours")
    @ManyToOne(optional = false)
    private Cours idcours;

    public Contenu() {
    }

    public Contenu(String libellecontenu, String descriptioncontenu, String documentcontenu) {
        this.libellecontenu = libellecontenu;
        this.descriptioncontenu = descriptioncontenu;
        this.documentcontenu = documentcontenu;
    }

    public Contenu(String libellecontenu, String descriptioncontenu, String documentcontenu, Cours idcours) {
        this.libellecontenu = libellecontenu;
        this.descriptioncontenu = descriptioncontenu;
        this.documentcontenu = documentcontenu;
        this.idcours = idcours;
    }

    public Integer getIdcontenu() {
        return idcontenu;
    }

    public void setIdcontenu(Integer idcontenu) {
        this.idcontenu = idcontenu;
    }

    public String getLibellecontenu() {
        return libellecontenu;
    }

    public void setLibellecontenu(String libellecontenu) {
        this.libellecontenu = libellecontenu;
    }

    public String getDescriptioncontenu() {
        return descriptioncontenu;
    }

    public void setDescriptioncontenu(String descriptioncontenu) {
        this.descriptioncontenu = descriptioncontenu;
    }

    public String getDocumentcontenu() {
        return documentcontenu;
    }

    public void setDocumentcontenu(String documentcontenu) {
        this.documentcontenu = documentcontenu;
    }

    public Cours getIdcours() {
        return idcours;
    }

    public void setIdcours(Cours idcours) {
        this.idcours = idcours;
    }
}
