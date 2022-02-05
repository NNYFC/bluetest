package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.CourDtao;
import com.winmoney.bluelantern.model.Cours;
import com.winmoney.bluelantern.model.Epreuve;
import com.winmoney.bluelantern.service.cours.CourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourController {

    @Autowired
    CourServices courServices;

    @RequestMapping(value = "/annee/cour",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Cours insereCours(@RequestBody CourDtao courDtao){
        return courServices.addCours(courDtao);
    }

    @RequestMapping(value = "/annee/{id}/cour",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Cours> displayAnneeacademiqueCours(@PathVariable int id){
        return courServices.getCoursByAnneeId(id);
    }

    @RequestMapping(value = "/annee/cour",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Cours updateCoursInfo(@RequestBody CourDtao courDtao, @RequestParam int id){
        return courServices.updateCours(courDtao,id);
    }

    @RequestMapping(value = "/cour",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Cours> displayAllCours(){
        return courServices.getAllCours();
    }

}
