package com.biblioteka.biblioteka.controller;

import com.biblioteka.biblioteka.model.Ksiazka;
import com.biblioteka.biblioteka.service.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/ksiazka")
public class KsiazkaController {

    @Autowired
    private KsiazkaService ksiazkaService;

    @GetMapping("/add")
    public String dodanieKsiazki(Model model) {

        model.addAttribute("newKsiazka", new Ksiazka());

        return "ksiazka-form";
    }

    @PostMapping("/add")
    public String dodanieKsiazki(Ksiazka ksiazka) {

        ksiazkaService.add(ksiazka);

        return "redirect:/ksiazka/list";
    }

    @GetMapping("/list")
    public String listaKsiazek(Model model) {
        model.addAttribute("listaKsiazek", ksiazkaService.getBazaDanych());

        return "ksiazka-list";
    }

    @GetMapping(path = "/delete/{ksiazkaIdentifier}")
    public String deleteKsiazka(@PathVariable Long ksiazkaIdentifier) {
        ksiazkaService.deleteById(ksiazkaIdentifier);

        return ("redirect:/ksiazka/list");
    }

    @GetMapping("/edit/{ksiazka_id}")
    public String editKsiazka(Model model, @PathVariable(name = "ksiazka_id") Long ksiazka_id) {

        return getKsiazkaToEdit(model, ksiazka_id);
    }

    private String getKsiazkaToEdit(Model model, @PathVariable(name = "ksiazka_id") Long ksiazka_id) {
        Optional<Ksiazka> optionalKsiazka = ksiazkaService.findKsiazka(ksiazka_id);
        if (optionalKsiazka.isPresent()) {
            Ksiazka ksiazka = optionalKsiazka.get();
            model.addAttribute("newKsiazka", ksiazka);

            return "ksiazka-form";
        }

        return "redirect:/ksiazka/list";
    }

    @GetMapping(path="/details")
    public String detaleKsiazki (Model model, @RequestParam Long ksiazkaIdentifier){
        Optional<Ksiazka> optionalKsiazka = ksiazkaService.findKsiazka(ksiazkaIdentifier);
        if (optionalKsiazka.isPresent()){
            Ksiazka ksiazka = optionalKsiazka.get();
            model.addAttribute("ksiazkaDetails", ksiazka);

            return "ksiazka-details";
        }
        return "redirect:/ksiazka/list";
    }

}