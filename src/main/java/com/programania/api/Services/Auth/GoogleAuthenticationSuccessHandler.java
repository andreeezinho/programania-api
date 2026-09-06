package com.programania.api.Services.Auth;

import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Services.Infra.JWT.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final GoogleAuthService googleAuthService;
    private final TokenService tokenService;

    public GoogleAuthenticationSuccessHandler(GoogleAuthService googleAuthService, TokenService tokenService) {
        this.googleAuthService = googleAuthService;
        this.tokenService = tokenService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2AuthenticationToken authToken =
                (OAuth2AuthenticationToken) authentication;

        Usuario user =
                googleAuthService.authByGoogleOAuth2(authToken);

        String token =
                tokenService.generateToken(user);

        response.sendRedirect(
                "http://localhost:5173/?token=" + token
        );
    }
}