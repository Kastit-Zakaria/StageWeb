package com.example.stageWeb.controller;

import com.example.stageWeb.entity.Inscription;
import com.example.stageWeb.repository.InscriptionRepository;
import com.example.stageWeb.repository.EnfantRepository;
import com.example.stageWeb.repository.StageRepository;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import org.springframework.validation.BindingResult;

@Controller
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private EnfantRepository enfantRepository;
    @Autowired
    private StageRepository stageRepository;

    @GetMapping("/inscriptions")
    public String viewInscriptions(Model model) {
        model.addAttribute("listInscriptions", inscriptionRepository.findAll());
        return "inscriptions";
    }

    @GetMapping("/showNewInscriptionForm")
    public String showNewInscriptionForm(Model model) {
        Inscription inscription = new Inscription();
        model.addAttribute("inscription", inscription);
        model.addAttribute("listEnfants", enfantRepository.findAll());
        model.addAttribute("listStages", stageRepository.findAll());
        return "new_inscription";
    }

    @PostMapping("/saveNewInscription")
    public String saveNewInscription(@Valid @ModelAttribute("inscription") Inscription inscription, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listEnfants", enfantRepository.findAll());
            model.addAttribute("listStages", stageRepository.findAll());
            return "new_inscription";
        }

        // Calculer l'âge de l'enfant
        LocalDate dateNaissance = inscription.getEnfant().getDateNaissance();
        int age = Period.between(dateNaissance, LocalDate.now()).getYears();

        // Vérifier que l'âge est dans la plage autorisée
        int ageMin = inscription.getStage().getAgeMin();
        int ageMax = inscription.getStage().getAgeMax();

        if (age < ageMin || age > ageMax) {
            model.addAttribute("erreurAge", "L'enfant n'a pas l'âge requis pour ce stage (entre " + ageMin + " et " + ageMax + " ans)");
            model.addAttribute("listEnfants", enfantRepository.findAll());
            model.addAttribute("listStages", stageRepository.findAll());
            return "new_inscription";
        }

        try {
            inscriptionRepository.save(inscription);
        } catch (Exception e) {
            model.addAttribute("erreurInscription", "Cet enfant est déjà inscrit à ce stage !");
            model.addAttribute("listEnfants", enfantRepository.findAll());
            model.addAttribute("listStages", stageRepository.findAll());
            return "new_inscription";
        }

        return "redirect:/inscriptions";
    }

    @GetMapping("/showUpdateInscriptionForm")
    public String showUpdateInscriptionForm(@RequestParam(name = "id") Integer id, Model model) {
        Inscription inscription = null;
        Optional<Inscription> optional = inscriptionRepository.findById(id);
        if (optional.isPresent()) {
            inscription = optional.get();
        } else {
            throw new RuntimeException("Inscription not found for id: " + id);
        }
        model.addAttribute("inscription", inscription);
        model.addAttribute("listEnfants", enfantRepository.findAll());
        model.addAttribute("listStages", stageRepository.findAll());
        return "update_inscription";
    }

    @PostMapping("/saveUpdateInscription")
    public String saveUpdateInscription(@Valid @ModelAttribute("inscription") Inscription inscription, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listEnfants", enfantRepository.findAll());
            model.addAttribute("listStages", stageRepository.findAll());
            return "update_inscription";
        }
        inscriptionRepository.save(inscription);
        return "redirect:/inscriptions";
    }

    @GetMapping("/deleteInscription")
    public String deleteInscription(@RequestParam(name = "id") Integer id) {
        inscriptionRepository.deleteById(id);
        return "redirect:/inscriptions";
    }
}
