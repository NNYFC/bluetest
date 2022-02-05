package com.winmoney.bluelantern.service.user;

import com.winmoney.bluelantern.dto.UserDtao;
import com.winmoney.bluelantern.model.Utilisateur;
import com.winmoney.bluelantern.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServicesImp implements UtilisateurServices {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Utilisateur addUtilisateur(UserDtao userDtao) {
        Optional<Utilisateur> optional = utilisateurRepository.findByEmailutilisateur(userDtao.getEmailutilisateur());
        if(optional.isPresent()){
            throw new RuntimeException("A user having this email already have an account");
        }else{
            Utilisateur user = new Utilisateur(
                    userDtao.getNomutilisateur(),userDtao.getEmailutilisateur(),
                    userDtao.getPseudoutilisateur(),
                    passwordEncoder.encode(userDtao.getMotdepasseutilisateur()),
                    userDtao.getRoleutilisateur()
            );

            return utilisateurRepository.save(user);
        }
    }

    @Override
    public Utilisateur updateUtilisateur(UserDtao userDtao,Long id) {
        Optional<Utilisateur> optional = utilisateurRepository.findById(id);
        if(optional.isPresent()){
            Utilisateur user = optional.get();

            user.setNomutilisateur(userDtao.getNomutilisateur());
            user.setEmailutilisateur(userDtao.getEmailutilisateur());
            user.setPseudoutilisateur(userDtao.getPseudoutilisateur());
            user.setMotdepasseutilisateur(passwordEncoder.encode(userDtao.getMotdepasseutilisateur()));
            //user.setMotdepasseutilisateur(userDtao.getMotdepasseutilisateur());

            return utilisateurRepository.save(user);
        }else{
            throw new RuntimeException("User not found for id = "+id);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> user = utilisateurRepository.findByEmailutilisateur(username);
        if(user.isPresent()){
            //return new CustomUserDetails(user.get());
            return new org.springframework.security.core.userdetails.User(
                    user.get().getEmailutilisateur(),user.get().getMotdepasseutilisateur(),
                    mapRolesToAuthorities(user.get().getRoleutilisateur())
            );

        }else {
            throw new UsernameNotFoundException("User not found");
        }

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String roles){
        return Collections.singleton(new SimpleGrantedAuthority(roles));
    }

    @Override
    public String deleteUtilisateur(Long id) {

        Optional<Utilisateur> optional = utilisateurRepository.findById(id);
        if (optional.isPresent()){
            utilisateurRepository.deleteById(id);
        }else {
            throw new RuntimeException("User not found for id = "+id);
        }
        return "Deleted Successfully";
    }

    @Override
    public List<Utilisateur> listUtilisateurList() {
        return utilisateurRepository.findAll();
    }
}
