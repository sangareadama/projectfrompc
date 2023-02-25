package com.sang.sangschoolback.controller;

import com.sang.sangschoolback.domain.Utilisateur;
import com.sang.sangschoolback.service.IUtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demo-controller")
public class demoController {

    private final IUtilisateurService iUtilisateurService;

    public demoController(IUtilisateurService iUtilisateurService) {
        this.iUtilisateurService = iUtilisateurService;
    }

    @GetMapping
    public ResponseEntity<String>  sayHello(){
        return ResponseEntity.ok("hello from secured endpoint");
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Utilisateur>> listeUtilisateur(){
        return ResponseEntity.ok(iUtilisateurService.listeUtilisateur());
    }
    @PostMapping("/supprimer")
    public void supprimerUtilisateur(@RequestBody Utilisateur utilisateur){
        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        // iUtilisateurService.supprimerUtilisateurParId(utilisateur);
        iUtilisateurService.supprimerUtilisateurParId(utilisateur);
    }
}
