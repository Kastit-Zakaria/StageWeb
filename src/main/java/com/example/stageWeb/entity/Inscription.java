/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.stageWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Kasti
 */
@Entity
@Table(name = "inscription", uniqueConstraints = @UniqueConstraint(columnNames = {"enfant_id", "stage_id"}))
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "L'enfant ne peut pas être vide")
@ManyToOne(fetch = FetchType.LAZY)
private Enfant enfant;

@NotNull(message = "Le stage ne peut pas être vide")
@ManyToOne(fetch = FetchType.LAZY)
private Stage stage;

@NotNull(message = "Le statut de paiement ne peut pas être vide")
private Boolean paye;

    public Inscription() {
    }

    public Inscription(Integer id, Boolean paye, Enfant enfant, Stage stage) {
        this.id = id;
        this.paye = paye;
        this.enfant = enfant;
        this.stage = stage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
