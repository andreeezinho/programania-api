package com.programania.api.Controllers.Auth;

import com.programania.api.DTO.Auth.AuthDTO;
import com.programania.api.DTO.Token.TokenDTO;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Services.Auth.GoogleAuthService;
import com.programania.api.Services.Infra.JWT.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private GoogleAuthService googleAuthService;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthDTO auth){
        var emailAndPassword = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
        var authenticate = authenticationManager.authenticate(emailAndPassword);

        var token = tokenService.generateToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @GetMapping("/google-link")
    public ResponseEntity<?> getGoogleAuth(HttpServletRequest request) {
        OAuth2AuthorizationRequestResolver resolver = new DefaultOAuth2AuthorizationRequestResolver(
            this.clientRegistrationRepository, "/oauth2/authorization"
        );

        OAuth2AuthorizationRequest authorizationRequest = resolver.resolve(request, "google");

        String authorizationUrl = authorizationRequest.getAuthorizationRequestUri();

        return ResponseEntity.ok(
            Map.of("url", authorizationUrl)
        );
    }

    @GetMapping("/google/success")
    public ResponseEntity<?> loginGoogle(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        Usuario user = this.googleAuthService.authByGoogleOAuth2(oAuth2AuthenticationToken);

        var token = tokenService.generateToken((Usuario) user);

        return ResponseEntity.ok(new TokenDTO(token));
    }

}




