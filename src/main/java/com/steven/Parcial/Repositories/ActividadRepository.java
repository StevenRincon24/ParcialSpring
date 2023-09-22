package com.steven.Parcial.Repositories;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    List<Actividad> findByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
}
