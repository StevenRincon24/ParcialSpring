package com.steven.Parcial.Repositories;

import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.Inscripcion;
import com.steven.Parcial.Entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByEventoId(Long eventoId);
}
