package com.steven.Parcial.Repositories;

import com.steven.Parcial.Entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipanteRepository   extends JpaRepository<Participante, Long> {
    List<Participante> findByTipo(String tipo);
    Optional<Participante> findById(Long idParticipante);
}
