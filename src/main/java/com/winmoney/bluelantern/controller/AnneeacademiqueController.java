package com.winmoney.bluelantern.controller;
;
import com.winmoney.bluelantern.dto.UtilisateuranneeacademiqueDtao;
import com.winmoney.bluelantern.model.Anneeacademique;
import com.winmoney.bluelantern.model.Utilisateuranneeacademique;
import com.winmoney.bluelantern.service.anneeacademique.AnneeacademiqueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnneeacademiqueController {

    @Autowired
    AnneeacademiqueServices anneeacademiqueServices;

    @RequestMapping(value = "/anneeacademique",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Anneeacademique addAnneeacademique(@RequestBody Anneeacademique anneeacademique){
        return anneeacademiqueServices.addAnneeacademique(anneeacademique);
    }

    @RequestMapping(value = "/anneeacademique",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Anneeacademique> listAllAnneeacademique(){
        return anneeacademiqueServices.listAnneeacademique();
    }

    @RequestMapping(value = "/users/annee",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Utilisateuranneeacademique registerToAnneeacademique(@RequestBody UtilisateuranneeacademiqueDtao utilisateuranneeacademiqueDtao){
        return anneeacademiqueServices.addUtilisateuranneeacademique(utilisateuranneeacademiqueDtao);
    }

}
