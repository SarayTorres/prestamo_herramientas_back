package com.ims.demo.controller;

import com.ims.demo.model.Prestamo;
import com.ims.demo.model.Usuario;
import com.ims.demo.model.Herramienta;
import com.ims.demo.repository.PrestamoRepository;
import com.ims.demo.repository.UsuarioRepository;
import com.ims.demo.repository.HerramientaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
@CrossOrigin(origins = "http://localhost:3000")
public class PrestamoController {

    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final HerramientaRepository herramientaRepository;

    public PrestamoController(PrestamoRepository prestamoRepository,
                              UsuarioRepository usuarioRepository,
                              HerramientaRepository herramientaRepository) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.herramientaRepository = herramientaRepository;
    }

    // 1. Crear préstamo
    @PostMapping("/crear")
    public String crearPrestamo(@RequestParam Long idUsuario,
                                @RequestParam String documento,
                                @RequestParam Long idHerramienta,
                                @RequestParam String fechaPrestamo,
                                @RequestParam String fechaDevolucion,
                                @RequestParam String estado) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isEmpty()) {
            return "Usuario no encontrado";
        }

        // Verificar que el documento coincida con el usuario
        if (!usuarioOpt.get().getDocumento().equals(documento)) {
            return "El documento no coincide con el usuario";
        }

        Optional<Herramienta> herramientaOpt = herramientaRepository.findById(idHerramienta);
        if (herramientaOpt.isEmpty()) {
            return "Herramienta no encontrada";
        }

        // Convertir las fechas de String a LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime fechaPrestamoDateTime = LocalDateTime.parse(fechaPrestamo, formatter);
        LocalDateTime fechaDevolucionDateTime = LocalDateTime.parse(fechaDevolucion, formatter);

        // Convertir estado de String a Integer
        Integer estadoInt = Integer.parseInt(estado);

        Prestamo prestamo = new Prestamo(usuarioOpt.get(), herramientaOpt.get(), fechaPrestamoDateTime, fechaDevolucionDateTime, estadoInt);
        prestamoRepository.save(prestamo);

        return "Préstamo creado correctamente para " + usuarioOpt.get().getNombre();
    }

    @GetMapping
    public List<Object[]> listarPrestamos() {
        return prestamoRepository.findPrestamosFiltrados();
    }
    
    @PutMapping("/cerrar/{idPrestamo}")
    public String cerrarPrestamo(@PathVariable Long idPrestamo) {
        int filasActualizadas = prestamoRepository.cerrarPrestamo(idPrestamo);
        if (filasActualizadas > 0) {
            return "Préstamo cerrado correctamente";
        } else {
            return "Préstamo no encontrado";
        }
    }
}
