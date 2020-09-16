package com.biblioteka.biblioteka.controller;

import com.biblioteka.biblioteka.model.Czytelnik;
import com.biblioteka.biblioteka.model.Oddzial;
import com.biblioteka.biblioteka.service.CzytelnikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/czytelnik")
@AllArgsConstructor
public class CzytelnikController {

    private final CzytelnikService czytelnikService;

    @GetMapping("/add")
    public String dodanieGatunku (Model model, @RequestParam("ksiazka_id") Long ksiazka_id){

        model.addAttribute("newCzytelnik", new Czytelnik());
        model.addAttribute("ksiazka_id", ksiazka_id);
        model.addAttribute("oddzial", Oddzial.values());

        return "czytelnik-form";
    }


    @PostMapping("/add")
    public String gatunekSave(Czytelnik czytelnik, Long okreslone){
        czytelnikService.saveGatunek(czytelnik, okreslone);

        return "redirect:/ksiazka/details?ksiazkaIdentifier=" + okreslone;
    }

    @GetMapping("/edit")
    public String editCzytelnik (Model model, @RequestParam(name ="czytelnikId") Long czytelnikId){

        Optional<Czytelnik> czytelnikOptional = czytelnikService.findById(czytelnikId);
        if (czytelnikOptional.isPresent()){
            Czytelnik czytelnik = czytelnikOptional.get();
            model.addAttribute("newCzytelnik", czytelnik);
            model.addAttribute("ksiazkaId", czytelnik.getKsiazka().getId());
            model.addAttribute("oddzial", Oddzial.values());

            return "czytelnik-form";
        }
        return "redirect:/ksiazka/list";
    }


}
