package com.itakademy.tpdavidsayagdfs24a.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity

public class Temps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Le champ temps ne peut pas être null")
    @NotBlank(message = "Le champ temps ne peut pas être vide")
    private String temps;
    @NotNull(message = "Le champ temperatureMin ne peut pas être null")
    @NotBlank(message = "Le champ temperatureMin ne peut pas être vide")
    private String temperatureMin;
    @NotNull(message = "Le champ temperatureMax ne peut pas être null")
    @NotBlank(message = "Le champ temperatureMax ne peut pas être vide")
    private String temperatureMax;
    @NotNull(message = "Le champ date ne peut pas être null")
    @NotBlank(message = "Le champ date ne peut pas être vide")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Temps(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Relation Temps à Residence
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Residence residence;

    public Temps(String temps, String temperatureMin, String temperatureMax, Date date){
        this.temps = temps;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.date = date;
    }

}
