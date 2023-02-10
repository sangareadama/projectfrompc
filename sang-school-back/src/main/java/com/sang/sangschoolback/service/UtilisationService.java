package com.sang.sangschoolback.service;

import com.sang.sangschoolback.controller.AuthenticationRequest;
import com.sang.sangschoolback.controller.AuthenticationResponse;
import com.sang.sangschoolback.domain.Utilisateur;
import com.sang.sangschoolback.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisationService implements IUtilisateurService{
    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<Utilisateur> listeUtilisateur() {
        return repository.findAll();
    }

    @Override
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
        return repository.save(utilisateur);
    }
}
