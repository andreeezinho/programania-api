package com.programania.api.Controllers.Usuario;

import java.util.UUID;

import com.programania.api.DTO.Usuario.UsuarioPasswordDTO;
import com.programania.api.Models.Usuario.Usuario;
//import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.programania.api.Services.Infra.FileStorageService;

import com.programania.api.Services.Usuario.UsuarioService;
import org.springframework.web.multipart.MultipartFile;

public class UsuarioController {
}
