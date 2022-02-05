package com.winmoney.bluelantern.service.user;

import com.winmoney.bluelantern.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    @Autowired
    private Utilisateur utilisateur;

    public CustomUserDetails(Utilisateur utilisateur) {
        super();
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(utilisateur.getRoleutilisateur()));
    }

    @Override
    public String getPassword() {
        return utilisateur.getMotdepasseutilisateur();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmailutilisateur();
    }

    public String getUsernom() {
        return utilisateur.getNomutilisateur();
    }

    public String getUserPseudo() {
        return utilisateur.getPseudoutilisateur();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
