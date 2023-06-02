package com.itakademy.tpdavidsayagdfs24a.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity

public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Le champ nom ne peut pas être null")
    private Integer nbPersonne;

    @NotNull(message = "Le champ nom ne peut pas être null")
    @NotBlank(message = "Le champ nom ne peut pas être vide")
    private String type;

    @NotNull(message = "Le champ nom ne peut pas être null")
    private Boolean principale;

    @NotNull(message = "Le champ nom ne peut pas être null")
    @NotBlank(message = "Le champ nom ne peut pas être vide")
    private String adresse;

    @NotNull(message = "Le champ nom ne peut pas être null")
    @NotBlank(message = "Le champ nom ne peut pas être vide")
    private String codePostal;

    @NotNull(message = "Le champ nom ne peut pas être null")
    private Double lat;

    @NotNull(message = "Le champ nom ne peut pas être null")
    private Double lon;

    // Constructeur

    public Residence(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(Integer nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    // Relation Residence -> user
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    // Relation Residence -> Temps
    @OneToMany(mappedBy="residence", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Temps> temps;

    // Relation Residence -> Cuve
    @OneToMany(mappedBy="residence", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Cuve> cuves;

    public Residence(Integer nbPersonne, String type, Boolean principale, String adresse, String codePostal, Double lat, Double lon) {
        this.nbPersonne = nbPersonne;
        this.type = type;
        this.principale = principale;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.lon = lon;
        this.lat = lat;
    }
}
