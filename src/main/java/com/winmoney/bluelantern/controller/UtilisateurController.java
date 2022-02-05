package com.winmoney.bluelantern.controller;

import com.winmoney.bluelantern.dto.AuthenticationResponse;
import com.winmoney.bluelantern.dto.UserDtao;
import com.winmoney.bluelantern.model.Utilisateur;
import com.winmoney.bluelantern.service.user.UtilisateurServices;
import com.winmoney.bluelantern.service.user.UtilisateurServicesImp;
import com.winmoney.bluelantern.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    UtilisateurServices utilisateurServices;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtility jwtTokenUtil;

    @RequestMapping(value = "/authenticate",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticateToken(@RequestBody UserDtao userDtao){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDtao.getEmailutilisateur(),userDtao.getMotdepasseutilisateur())
        );
        final UserDetails userDetails = utilisateurServices.loadUserByUsername(userDtao.getEmailutilisateur());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @RequestMapping(value = "/admin",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Utilisateur addAdmin(@RequestBody UserDtao userDtao){
        userDtao.setRoleutilisateur("ADMIN");
        return utilisateurServices.addUtilisateur(userDtao);
    }

    @RequestMapping(value = "/user/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST)
    Utilisateur userRegistration(@RequestBody UserDtao userDtao){
        userDtao.setRoleutilisateur("STUDENT");
        return utilisateurServices.addUtilisateur(userDtao);
    }

    @RequestMapping(value = "/users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.PUT)
    Utilisateur userUpdateInfo(@RequestBody UserDtao userDtao,@PathVariable Long id){
        return utilisateurServices.updateUtilisateur(userDtao,id);
    }

    @RequestMapping(value = "/users/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.DELETE)
    String deleteAllUserInfo(@PathVariable Long id){
        return utilisateurServices.deleteUtilisateur(id);
    }

    @RequestMapping(value = "/users",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    List<Utilisateur> displayAllUserInfo(){
        return utilisateurServices.listUtilisateurList();
    }

}
