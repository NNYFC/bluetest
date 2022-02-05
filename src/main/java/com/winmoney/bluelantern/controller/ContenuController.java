package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.ContenuDtao;
import com.winmoney.bluelantern.model.Contenu;
import com.winmoney.bluelantern.service.contenu.ContenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContenuController {

    @Autowired
    ContenuServices contenuServices;

    @RequestMapping(value = "/annee/cour/contenu",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Contenu insereContenu(@RequestBody ContenuDtao contenuDtao){
        return contenuServices.addContenu(contenuDtao);
    }

    @RequestMapping(value = "/annee/cour/contenu",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Contenu updateContenuInfo(@RequestBody ContenuDtao contenuDtao, @RequestParam int id){
        return contenuServices.updateContenu(contenuDtao,id);
    }

    @RequestMapping(value = "/cour/{id}/contenu",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Contenu> getContenuInfoByCourId(@PathVariable int id){
        return contenuServices.listContenuByIdcours(id);
    }

}
