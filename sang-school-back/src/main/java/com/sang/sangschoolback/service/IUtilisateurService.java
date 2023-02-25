package com.sang.sangschoolback.service;

import com.sang.sangschoolback.domain.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    public List<Utilisateur> listeUtilisateur();
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur);
    public void supprimerUtilisateurParId(Utilisateur utilisateur);


}
