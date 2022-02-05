package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.QuestionepreuveDtao;
import com.winmoney.bluelantern.dto.ReponseepreuveDtao;
import com.winmoney.bluelantern.model.Epreuve;
import com.winmoney.bluelantern.model.Questionepreuve;
import com.winmoney.bluelantern.model.Reponseepreuve;
import com.winmoney.bluelantern.service.epreuve.EpreuveServices;
import com.winmoney.bluelantern.service.questionepreuve.QuestionepreuveServices;
import com.winmoney.bluelantern.service.reponseepreuve.ReponseepreuveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EpreuveController {

    @Autowired
    EpreuveServices epreuveServices;

    @Autowired
    QuestionepreuveServices questionepreuveServices;

    @Autowired
    ReponseepreuveServices reponseepreuveServices;

    @RequestMapping(value = "/epreuve",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Epreuve insereEpreuve(@RequestBody Epreuve epreuve){
        return epreuveServices.addEpreuve(epreuve);
    }

    @RequestMapping(value = "/epreuve",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Epreuve updateEpreuveInfo(@RequestBody Epreuve epreuve,@RequestParam int id){
        return epreuveServices.updateEpreuve(epreuve,id);
    }

    @RequestMapping(value = "/epreuve",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Epreuve> displayAllEpreuve(){
        return epreuveServices.listAllEpreuve();
    }

    @RequestMapping(value = "/epreuve/question",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Questionepreuve insereQuestionepreuve(@RequestBody QuestionepreuveDtao questionepreuveDtao){
        return questionepreuveServices.addQuestionepreuve(questionepreuveDtao);
    }

    @RequestMapping(value = "/epreuve/question/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Questionepreuve updateQuestionepreuve(@RequestBody QuestionepreuveDtao questionepreuveDtao,@PathVariable int id){
        return questionepreuveServices.updateQuestionepreuve(questionepreuveDtao,id);
    }

    @RequestMapping(value = "/epreuve/{id}/question",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Questionepreuve> displayQuestionepreuve(@PathVariable int id){
        return questionepreuveServices.listEpreuveQuestions(id);
    }

    @RequestMapping(value = "/epreuve/question/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.DELETE)
    String deleteQuestionepreuve(@PathVariable int id){
        return questionepreuveServices.deleteQuestionepreuve(id);
    }

    @RequestMapping(value = "/epreuve/question/reponse",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Reponseepreuve insereResponseepreuve(@RequestBody ReponseepreuveDtao reponseepreuveDtao){
        return reponseepreuveServices.addReponseepreuve(reponseepreuveDtao);
    }

    @RequestMapping(value = "/epreuve/question/reponse/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Reponseepreuve updateResponseepreuve(@RequestBody ReponseepreuveDtao reponseepreuveDtao,@PathVariable int id){
        return reponseepreuveServices.updateReponseepreuve(reponseepreuveDtao,id);
    }

    @RequestMapping(value = "/epreuve/question/{id}/reponse",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Reponseepreuve> displayReponseepreuve(@PathVariable int id){
        return reponseepreuveServices.listReponseEpreuveByQuestionId(id);
    }

    @RequestMapping(value = "/epreuve/question/reponse/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.DELETE)
    String deleteReponseepreuve(@PathVariable int id){
        return reponseepreuveServices.deleteReponseepreuve(id);
    }

}
