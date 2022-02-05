package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.ScoreDtao;
import com.winmoney.bluelantern.model.Scoreepreuve;
import com.winmoney.bluelantern.model.Scorequiz;
import com.winmoney.bluelantern.service.score.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreController {

    @Autowired
    ScoreServices scoreServices;

    @RequestMapping(value = "/quiz/score",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Scorequiz addScorequiz(@RequestBody ScoreDtao scoreDtao){
        return scoreServices.addScorequiz(scoreDtao);
    }

    @RequestMapping(value = "/quiz/score",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    Scorequiz displayUserScorequiz(@RequestParam Long id){
        return scoreServices.listScorequizByUserIdUserId(id);
    }

    @RequestMapping(value = "/epreuve/score",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Scoreepreuve addScoreepreuve(@RequestBody ScoreDtao scoreDtao){
        return scoreServices.addScoreepreuve(scoreDtao);
    }

    @RequestMapping(value = "/epreuve/score",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    Scoreepreuve displayUserScoreepreuve(@RequestParam Long id){
        return scoreServices.listScoreepreuveByUserId(id);
    }

}
