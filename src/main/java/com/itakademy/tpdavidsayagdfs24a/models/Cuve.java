package com.itakademy.tpdavidsayagdfs24a.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Cuve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Le champ masse ne peut pas être null")
    private Double masse;

    @NotNull(message = "Le champ masse ne peut pas être null")
    private Double contenance;

    @NotNull(message = "Le champ masse ne peut pas être null")
    @NotBlank(message = "Le champ masse ne peut pas être vide")
    private String numeroSerie;

    // Constructeur
    public Cuve(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMasse() {
        return masse;
    }

    public void setMasse(Double masse) {
        this.masse = masse;
    }

    public Double getContenance() {
        return contenance;
    }

    public void setContenance(Double contenance) {
        this.contenance = contenance;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    // Relation Cuve -> Residence
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Residence residence;

    // Relation Cuve -> Donnee
    @OneToMany(mappedBy="cuve", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Donnee> donnees;

    public Cuve(Double masse, Double contenance, String numeroSerie){
        this.masse = masse;
        this.contenance = contenance;
        this.numeroSerie = numeroSerie;

    }
}
