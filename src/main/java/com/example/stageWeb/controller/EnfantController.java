/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.stageWeb.controller;

import com.example.stageWeb.entity.Enfant;
import com.example.stageWeb.repository.EnfantRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kasti
 */
@Controller
public class EnfantController {

    @Autowired
    private EnfantRepository enfantRepository;

    @GetMapping("/enfants")
    public String viewEnfants(Model model, @RequestParam(name = "nom", required = false, defaultValue = "") String nom) {
        if (nom.isEmpty()) {
            model.addAttribute("listEnfants", enfantRepository.findAll());
        } else {
            model.addAttribute("listEnfants", enfantRepository.findByNomContaining(nom));
        }
        model.addAttribute("nom", nom);
        return "enfants";
    }

    @GetMapping("/showNewEnfantForm")
    public String showNewEnfantForm(Model model) {
        Enfant enfant = new Enfant();
        model.addAttribute("enfant", enfant);
        return "new_enfant";
    }

    @PostMapping("/saveNewEnfant")
    public String saveNewEnfant(@Valid @ModelAttribute("enfant") Enfant enfant, BindingResult result) {
        if (result.hasErrors()) {
            return "new_enfant";
        }
        enfantRepository.save(enfant);
        return "redirect:/enfants";
    }

    @GetMapping("/showUpdateEnfantForm")
    public String showUpdateEnfantForm(@RequestParam(name = "id") Integer id, Model model) {
        Enfant enfant = null;
        Optional<Enfant> optional = enfantRepository.findById(id);
        if (optional.isPresent()) {
            enfant = optional.get();
        } else {
            throw new RuntimeException("Enfant not found for id: " + id);
        }
        model.addAttribute("enfant", enfant);
        return "update_enfant";
    }

    @PostMapping("/saveUpdateEnfant")
    public String saveUpdateEnfant(@Valid @ModelAttribute("enfant") Enfant enfant, BindingResult result) {
        if (result.hasErrors()) {
            return "update_enfant";
        }
        enfantRepository.save(enfant);
        return "redirect:/enfants";
    }

    @GetMapping("/deleteEnfant")
    public String deleteEnfant(@RequestParam(name = "id") Integer id) {
        enfantRepository.deleteById(id);
        return "redirect:/enfants";
    }
}
