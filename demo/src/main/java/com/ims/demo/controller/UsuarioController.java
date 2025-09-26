package com.ims.demo.controller;

import com.ims.demo.model.Usuario;
import com.ims.demo.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String documento, @RequestParam String contrasena) {
        Map<String, Object> response = new HashMap<>();
        
        Optional<Usuario> usuarioOpt = usuarioRepository.findByDocumento(documento);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getContrasena().equals(contrasena)) {
                response.put("success", true);
                response.put("message", "Login exitoso");
                response.put("usuario", usuario);
            } else {
                response.put("success", false);
                response.put("message", "Contraseña incorrecta");
            }
        } else {
            response.put("success", false);
            response.put("message", "Usuario no encontrado");
        }
        return response;
    }
}
