package com.example.stageWeb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 * @author Kasti
 */
@Entity
@Table(name = "stage")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotBlank(message = "La dénomination ne peut pas être vide")
    private String denom;
    @NotNull(message = "L'âge minimum ne peut pas être vide")
    @Min(value = 3, message = "L'âge minimum doit être au moins 3 ans")
    @Max(value = 18, message = "L'âge minimum ne peut pas dépasser 18 ans")
    private Integer ageMin;
    @NotNull(message = "L'âge maximum ne peut pas être vide")
    @Min(value = 3, message = "L'âge maximum doit être au moins 3 ans")
    @Max(value = 18, message = "L'âge maximum ne peut pas dépasser 18 ans")
    private Integer ageMax;
    @NotNull(message = "La date de début ne peut pas être vide")
    private LocalDate dateDeb;
    @NotNull(message = "La date de fin ne peut pas être vide")
    private LocalDate dateFin;
    @NotNull(message = "Le prix ne peut pas être vide")
    private Integer prix;

    public Stage() {
    }

    public Stage(String denom, Integer ageMin, Integer ageMax, LocalDate dateDeb, LocalDate dateFin, Integer prix) {
        this.denom = denom;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
