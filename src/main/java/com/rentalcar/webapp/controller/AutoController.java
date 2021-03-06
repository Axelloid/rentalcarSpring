package com.rentalcar.webapp.controller;

import com.rentalcar.webapp.entity.Automezzo;
import com.rentalcar.webapp.entity.TipologiaAutomezzo;
import com.rentalcar.webapp.entity.TipologiaUtente;
import com.rentalcar.webapp.entity.Utente;
import com.rentalcar.webapp.service.AutoService;
import com.rentalcar.webapp.service.TipologiaAutoService;
import com.rentalcar.webapp.service.TipologiaUtenteService;
import com.rentalcar.webapp.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class AutoController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private TipologiaAutoService tipologiaAutoService;

    @GetMapping("/auto")
    public String userForm(Locale locale, Model model){
        model.addAttribute("auto", autoService.getAllAutomezzi());
        model.addAttribute("listaCategorie", tipologiaAutoService.getAllTipologie());
        return "lista-auto";
    }

    @RequestMapping(value = "auto/addAuto")
    public String addCustomerForm(Locale locale, Model model){
        model.addAttribute("command", new Automezzo());
        model.addAttribute("listaCategorie", tipologiaAutoService.getAllTipologie());
        return "update-auto-form";
    }

    @PostMapping(value = "/auto/updateAuto/{autoId}")
    public String updateAutoForm(@PathVariable("autoId") String autoId, Locale locale, Model model){
        Long id = Long.parseLong(autoId);
        model.addAttribute("command", new Automezzo());
        model.addAttribute("listaCategorie", tipologiaAutoService.getAllTipologie());
        model.addAttribute("updateAuto", autoService.getAutomezzo(id));
        return "update-auto-form";
    }

    @RequestMapping(value= "/auto/addAuto/save", method = RequestMethod.POST)
    public String addAuto(@ModelAttribute("auto") Automezzo p){

        TipologiaAutomezzo miaCategoria = this.tipologiaAutoService.getCategoria(p.getCategoria().getCategoria());
        Automezzo nuovoAutomezzo;
        if (p.getId()== null){
            nuovoAutomezzo = new Automezzo(p.getTarga(), p.getCasacostruttrice(), p.getModello(), p.getImmatricolazione(), miaCategoria);
            this.autoService.save(nuovoAutomezzo);
        }
        else {
            nuovoAutomezzo = new Automezzo(p.getId(), p.getTarga(), p.getCasacostruttrice(), p.getModello(), p.getImmatricolazione(), miaCategoria);
            this.autoService.update(nuovoAutomezzo);
        }

        return "redirect:/auto";
    }

    @PostMapping("/auto/delete/{autoId}")
    private String deleteAuto(@PathVariable("autoId") String autoId) {
        Long id = Long.parseLong(autoId);
        autoService.delete(id);
        return "redirect:/auto";
    }

    @GetMapping(value = "/auto/search/")
    public String searchCustomers(@RequestParam (value = "searchAuto") String search, Model model){
        model.addAttribute("auto", autoService.getAllAutoFromCategoria(search));
        model.addAttribute("listaCategorie", tipologiaAutoService.getAllTipologie());
        return "lista-auto";
    }

}
