package com.itakademy.tpdavidsayagdfs24a.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Le champ nom ne peut pas être null")
    @NotBlank(message = "Le champ nom ne peut pas être vide")
    private String nom;
    @NotNull(message = "Le champ prenom ne peut pas être null")
    @NotBlank(message = "Le champ prenom ne peut pas être vide")
    private String prenom;
    @NotNull(message = "Le champ email ne peut pas être null")
    @NotBlank(message = "Le champ email ne peut pas être vide")
    private String email;
    @NotNull(message = "Le champ mdp ne peut pas être null")
    @NotBlank(message = "Le champ mdp ne peut pas être vide")
    private String mdp;
    @NotNull(message = "Le champ telephone ne peut pas être null")
    @NotBlank(message = "Le champ telephone ne peut pas être vide")
    private String telephone;
    @NotNull(message = "Le champ portable ne peut pas être null")
    @NotBlank(message = "Le champ portable ne peut pas être vide")
    private String portable;
    @NotNull(message = "Le champ prenom ne peut pas être null")
    private Boolean actif;

    // Constructeur
    public User() {
    }

    // Getter & setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    // Relation User -> Residence
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Residence> residences;

    public User(String nom, String prenom, String email, String mdp, String telephone, String portable, Boolean actif) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.telephone = telephone;
        this.portable = portable;
        this.actif = actif;
    }
}