package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.QuestionquizDtao;
import com.winmoney.bluelantern.dto.ReponsequizDtao;
import com.winmoney.bluelantern.dto.UtilisateurquestionquizDtao;
import com.winmoney.bluelantern.model.Questionquiz;
import com.winmoney.bluelantern.model.Quiz;
import com.winmoney.bluelantern.model.Reponsequiz;
import com.winmoney.bluelantern.model.Utilisateurquestionquiz;
import com.winmoney.bluelantern.service.questionquiz.QuestionquizServices;
import com.winmoney.bluelantern.service.quiz.QuizServices;
import com.winmoney.bluelantern.service.reponsequiz.ReponsequizServices;
import com.winmoney.bluelantern.service.utilisateurquestionquiz.UtilisateurquestionquizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @Autowired
    QuestionquizServices questionquizServices;
    @Autowired
    ReponsequizServices reponsequizServices;
    @Autowired
    UtilisateurquestionquizService utilisateurquestionquizService;

    @RequestMapping(value = "/quiz",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Quiz insereQuiz(@RequestBody Quiz quiz){
        return quizServices.addQuiz(quiz);
    }

    @RequestMapping(value = "/quiz",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Quiz updateQuizInfo(@RequestBody Quiz quiz,@RequestParam int id){
        return quizServices.updateQuiz(quiz,id);
    }

    @RequestMapping(value = "/quiz",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Quiz> displayAllQuiz(){
        return quizServices.listAllQuiz();
    }

    @RequestMapping(value = "/quiz/question",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Questionquiz insereQuestionQuiz(@RequestBody QuestionquizDtao questionquizDtao){
        return questionquizServices.addQuestionquiz(questionquizDtao);
    }

    @RequestMapping(value = "/quiz/question/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Questionquiz updateQuestionQuiz(@RequestBody QuestionquizDtao questionquizDtao,@PathVariable int id){
        return questionquizServices.updateQuestionquiz(questionquizDtao,id);
    }

    @RequestMapping(value = "/quiz/{id}/question",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Questionquiz> displayQuestionQuiz(@PathVariable int id){
        return questionquizServices.listQuizQuestions(id);
    }

    @RequestMapping(value = "/quiz/question/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.DELETE)
    String deleteQuestionQuiz(@PathVariable int id){
        return questionquizServices.deleteQuestionquiz(id);
    }

    @RequestMapping(value = "/quiz/question/reponse",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Reponsequiz insereResponseQuiz(@RequestBody ReponsequizDtao reponsequizDtao){
        return reponsequizServices.addReponsequiz(reponsequizDtao);
    }

    @RequestMapping(value = "/quiz/question/reponse/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Reponsequiz updateResponseQuiz(@RequestBody ReponsequizDtao reponsequizDtao,@PathVariable int id){
        return reponsequizServices.updateReponsequiz(reponsequizDtao,id);
    }

    @RequestMapping(value = "/quiz/question/{id}/reponse",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Reponsequiz> displayReponsequiz(@PathVariable int id){
        return reponsequizServices.listReponseQuizByQuestionId(id);
    }

    @RequestMapping(value = "/quiz/question/reponse/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.DELETE)
    String deleteReponsequiz(@PathVariable int id){
        return reponsequizServices.deleteReponsequiz(id);
    }

    @RequestMapping(value = "/lastquestion/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Utilisateurquestionquiz inserelastUserQuizAnswer(@RequestBody UtilisateurquestionquizDtao utilisateurquestionquizDtao){
        return utilisateurquestionquizService.addUtilisateurquestionquiz(utilisateurquestionquizDtao);
    }

    @RequestMapping(value = "/quiz/{idquiz}/lastquestion/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    Utilisateurquestionquiz getlastUserQuizAnswer(@RequestParam long id,@PathVariable int idquiz){
        return utilisateurquestionquizService.getLastUserQuestionquiz(id,idquiz);
    }


}
