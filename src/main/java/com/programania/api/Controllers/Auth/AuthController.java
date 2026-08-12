package com.programania.api.Controllers.Auth;

import com.programania.api.DTO.Auth.AuthDTO;
import com.programania.api.DTO.Token.TokenDTO;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Services.Infra.JWT.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthDTO auth){
        var emailAndPassword = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
        var authenticate = authenticationManager.authenticate(emailAndPassword);

        var token = tokenService.generateToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

}




