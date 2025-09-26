package com.ims.demo.controller;

import com.ims.demo.model.Herramienta;
import com.ims.demo.repository.HerramientaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herramientas")
@CrossOrigin(origins = "http://localhost:3000")
public class HerramientaController {

    private final HerramientaRepository herramientaRepository;

    public HerramientaController(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    // 1. Listar todas las herramientas
    @GetMapping
    public List<Herramienta> getAllHerramientas() {
        return herramientaRepository.findAll();
    }

    // 2. Registrar nueva herramienta (opcional)
    @PostMapping
    public Herramienta createHerramienta(@RequestBody Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }
}
