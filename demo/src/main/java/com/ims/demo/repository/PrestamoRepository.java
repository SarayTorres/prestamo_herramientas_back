package com.ims.demo.repository;

import com.ims.demo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    
    @Query("SELECT p.idPrestamo, u.nombre, u.documento, h.nombre, p.fechaPrestamo, p.fechaDevolucion, p.estado FROM Prestamo p JOIN p.usuario u JOIN p.herramienta h")
    List<Object[]> findPrestamosFiltrados();
    
    @Modifying
    @Transactional
    @Query("UPDATE Prestamo p SET p.estado = 0, p.devuelto = true WHERE p.idPrestamo = :idPrestamo")
    int cerrarPrestamo(@Param("idPrestamo") Long idPrestamo);
}
