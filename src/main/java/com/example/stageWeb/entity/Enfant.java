/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.stageWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 * @author Kasti
 */
@Entity
@Table(name = "enfant")
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    private String prenom;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le sexe ne peut pas être vide")
    private Gender sexe;

    @NotNull(message = "La date de naissance ne peut pas être vide")
    private LocalDate dateNaissance;

    public Enfant() {
    }

    public Enfant(String nom, String prenom, Gender sexe, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }

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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Gender getSexe() {
        return sexe;
    }

    public void setSexe(Gender sexe) {
        this.sexe = sexe;
    }

}
