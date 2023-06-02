package com.itakademy.tpdavidsayagdfs24a.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Donnee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Le champ masse ne peut pas être null")
    private Double masse;

    @NotNull(message = "Le champ date ne peut pas être null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;

    public Donnee(){

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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    // Relation Donnee -> Cuve
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cuve cuve;

    public Donnee(Double masse, Date dateCreation){
        this.masse = masse;
        this.dateCreation = dateCreation;
    }
}
