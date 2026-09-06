package com.programania.api.Services.Auth;

import com.programania.api.DTO.Usuario.UsuarioDTO;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Models.Usuario.UsuarioRole;
import com.programania.api.Repositories.Usuario.UsuarioRepository;
import com.programania.api.Services.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario authByGoogleOAuth2(OAuth2AuthenticationToken authToken){
        OAuth2User oAuth2User = authToken.getPrincipal();

        UserDetails findUser = this.usuarioRepository.findByEmail(oAuth2User.getAttribute("email"));

        if(findUser == null){
            Usuario user = new Usuario();

            user.setLogin(oAuth2User.getAttribute("email"));
            user.setEmail(oAuth2User.getAttribute("email"));
            user.setNome(oAuth2User.getAttribute("name"));
            user.setAtivo(true);
            user.setPassword("");
            user.setRole(UsuarioRole.USER);
            user.setIcone(oAuth2User.getAttribute("picture"));

            return this.usuarioRepository.save(user);
        }

        return (Usuario) findUser;
    }

}
