package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.NiveaufiliereDtao;
import com.winmoney.bluelantern.model.Filiere;
import com.winmoney.bluelantern.model.Niveau;
import com.winmoney.bluelantern.model.Niveaufiliere;
import com.winmoney.bluelantern.service.filiere.FiliereServices;
import com.winmoney.bluelantern.service.niveau.NiveauServices;
import com.winmoney.bluelantern.service.niveaufiliere.NiveaufiliereServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Niveau_FiliereController {

    @Autowired
    NiveauServices niveauServices;
    @Autowired
    FiliereServices filiereServices;
    @Autowired
    NiveaufiliereServices niveaufiliereServices;

    @RequestMapping(value = "/niveau",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Niveau insereNiveau(@RequestBody Niveau niveau){
        return niveauServices.addNiveau(niveau);
    }

    @RequestMapping(value = "/niveau",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Niveau> listAllNiveau(){
        return niveauServices.getAllNiveau();
    }

    @RequestMapping(value = "/niveau",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Niveau updateNiveauInfo(@RequestBody Niveau niveau,@RequestParam Long id){
        return niveauServices.updateNiveau(niveau,id);
    }

    @RequestMapping(value = "/filiere",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Filiere addFilieer(@RequestBody Filiere filiere){
        return filiereServices.addFiliere(filiere);
    }

    @RequestMapping(value = "/filiere",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Filiere> listAllFilieer(){
        return filiereServices.getAllFiliere();
    }

    @RequestMapping(value = "/filiere",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Filiere updateFilieerInfo(@RequestBody Filiere filiere,@RequestParam Long id){
        return filiereServices.updateFiliere(filiere,id);
    }

    @RequestMapping(value = "/filiere/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    String removeFilieer(@PathVariable Long id){
        return filiereServices.deleteFiliere(id);
    }

    @RequestMapping(value = "/niveaufiliere",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Niveaufiliere insereNiveaufiliere(@RequestBody NiveaufiliereDtao niveaufiliereDtao){
        return niveaufiliereServices.addNiveaufiliere(niveaufiliereDtao);
    }

    @RequestMapping(value = "/niveaufiliere",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Niveaufiliere> listAllNiveaufiliere(){
        return niveaufiliereServices.getAllNiveauFiliere();
    }

}
