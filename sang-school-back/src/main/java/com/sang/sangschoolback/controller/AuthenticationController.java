package com.sang.sangschoolback.controller;

import com.sang.sangschoolback.domain.Utilisateur;
import com.sang.sangschoolback.service.AuthenticationService;
import com.sang.sangschoolback.service.IUtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final IUtilisateurService iUtilisateurService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Utilisateur>> listeUtilisateure(){

        return ResponseEntity.ok(iUtilisateurService.listeUtilisateur());
    }
}
