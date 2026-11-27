package com.example.stageWeb.controller;

import com.example.stageWeb.entity.Stage;
import com.example.stageWeb.repository.StageRepository;
import jakarta.validation.Valid;
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
public class StageController {

    @Autowired
    private StageRepository stageRepository;

    @GetMapping("/stages")
    public String viewStages(Model model, @RequestParam(name = "denom", required = false, defaultValue = "") String denom) {
        if (denom.isEmpty()) {
            model.addAttribute("listStages", stageRepository.findAll());
        } else {
            model.addAttribute("listStages", stageRepository.findByDenomContaining(denom));
        }
        model.addAttribute("denom", denom);
        return "stages";
    }

    @GetMapping("/showNewStageForm")
    public String showNewStageForm(Model model) {
        Stage stage = new Stage();
        model.addAttribute("stage", stage);
        return "new_stage";
    }

    @PostMapping("/saveNewStage")
    public String saveNewStage(@Valid @ModelAttribute("stage") Stage stage, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new_stage";
        }
        if (stage.getAgeMax() <= stage.getAgeMin()) {
            model.addAttribute("erreurAge", "L'âge max doit être plus grand que l'âge min !");
            return "new_stage";
        }
        if (!stage.getDateFin().isAfter(stage.getDateDeb())) {
            model.addAttribute("erreurDate", "La date de fin doit être postérieure à la date de début !");
            return "new_stage";
        }
        stageRepository.save(stage);
        return "redirect:/stages";
    }

    @GetMapping("/showUpdateStageForm")
    public String showUpdateStageForm(@RequestParam(name = "id") Integer id, Model model) {
        Stage stage = null;
        Optional<Stage> optional = stageRepository.findById(id);
        if (optional.isPresent()) {
            stage = optional.get();
        } else {
            throw new RuntimeException("Stage not found for id: " + id);
        }
        model.addAttribute("stage", stage);
        return "update_stage";
    }

    @PostMapping("/saveUpdateStage")
    public String saveUpdateStage(@Valid @ModelAttribute("stage") Stage stage, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update_stage";
        }
        if (stage.getAgeMax() <= stage.getAgeMin()) {
            model.addAttribute("erreurAge", "L'âge max doit être plus grand que l'âge min !");
            return "update_stage";
        }
        if (!stage.getDateFin().isAfter(stage.getDateDeb())) {
            model.addAttribute("erreurDate", "La date de fin doit être postérieure à la date de début !");
            return "update_stage";
        }
        stageRepository.save(stage);
        return "redirect:/stages";
    }

    @GetMapping("/deleteStage")
    public String deleteStage(@RequestParam(name = "id") Integer id) {
        stageRepository.deleteById(id);
        return "redirect:/stages";
    }
}
