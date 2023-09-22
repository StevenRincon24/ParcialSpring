package com.steven.Parcial.Service;

import com.steven.Parcial.Entities.Inscripcion;
import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public List<Participante> obtenerParticipantesPorEvento(Long eventoId) {
        List<Inscripcion> inscripciones = inscripcionRepository.findByEventoId(eventoId);
        return inscripciones.stream().map(Inscripcion::getParticipante).collect(Collectors.toList());
    }

    public Float calcularValorTotalInscripciones(Long eventoId) {
        List<Inscripcion> inscripciones = inscripcionRepository.findByEventoId(eventoId);
        float valorTotal = 0.0f;

        for (Inscripcion inscripcion : inscripciones) {
            valorTotal += inscripcion.getValor();
        }

        return valorTotal;
    }

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }


}
