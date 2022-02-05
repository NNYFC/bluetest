package com.winmoney.bluelantern.model;

import javax.persistence.*;

@Entity
@Table(name = "niveaufiliere")
public class Niveaufiliere {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idniveaufiliere")
    private Long idniveaufiliere;

    @JoinColumn(name = "idfiliere", referencedColumnName = "idfiliere")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Filiere idfiliere;

    @JoinColumn(name = "idniveau", referencedColumnName = "idniveau")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Niveau idniveau;

    public Niveaufiliere() {
    }

    public Niveaufiliere(Filiere idfiliere, Niveau idniveau) {
        this.idfiliere = idfiliere;
        this.idniveau = idniveau;
    }

    public Long getIdniveaufiliere() {
        return idniveaufiliere;
    }

    public void setIdniveaufiliere(Long idniveaufiliere) {
        this.idniveaufiliere = idniveaufiliere;
    }

    public Filiere getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Filiere idfiliere) {
        this.idfiliere = idfiliere;
    }

    public Niveau getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Niveau idniveau) {
        this.idniveau = idniveau;
    }
}
