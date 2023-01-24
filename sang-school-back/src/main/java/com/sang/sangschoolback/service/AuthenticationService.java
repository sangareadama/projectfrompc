package com.sang.sangschoolback.service;

import com.sang.sangschoolback.config.JwtService;
import com.sang.sangschoolback.controller.AuthenticationRequest;
import com.sang.sangschoolback.controller.AuthenticationResponse;
import com.sang.sangschoolback.controller.RegisterRequest;
import com.sang.sangschoolback.domain.Role;
import com.sang.sangschoolback.domain.Utilisateur;
import com.sang.sangschoolback.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var utilisateur = Utilisateur.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(utilisateur);
        var jwtToken = jwtService.generateToken(utilisateur);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
       /* authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );*/
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        var utilisateur = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(utilisateur);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
