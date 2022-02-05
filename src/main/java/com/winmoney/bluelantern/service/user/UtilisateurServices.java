package com.winmoney.bluelantern.service.user;

import com.winmoney.bluelantern.dto.UserDtao;
import com.winmoney.bluelantern.model.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurServices extends UserDetailsService {
    Utilisateur addUtilisateur(UserDtao userDtao);
    Utilisateur updateUtilisateur(UserDtao userDtao,Long id);
    String deleteUtilisateur(Long id);
    List<Utilisateur> listUtilisateurList();
}
