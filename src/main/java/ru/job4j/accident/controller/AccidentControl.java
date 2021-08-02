package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentService;

@Controller
public class AccidentControl {
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("accidentTypes", service.getAllAccidentTypes());
        model.addAttribute("accident", new Accident("", "", "", new AccidentType()).setId(0));
        return "accident/edit";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accidentTypes", service.getAllAccidentTypes());
        service.findAccidentById(id)
                .ifPresent(accident -> model.addAttribute("accident", accident));
        return "accident/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.findAccidentTypeById(accident.getType().getId())
                .ifPresent(accident::setType);
        service.saveAccident(accident);
        return "redirect:/";
    }
}