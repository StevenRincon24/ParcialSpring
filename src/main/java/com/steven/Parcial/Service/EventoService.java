package com.steven.Parcial.Service;

import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.Inscripcion;
import com.steven.Parcial.Entities.NotFoundException;
import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Repositories.EventoRepository;
import com.steven.Parcial.Repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public List<Participante> obtenerParticipantesPorEvento(Long eventoId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new NotFoundException("Evento no encontrado"));

        return evento.getParticipantes();
    }

    public Float obtenerValorTotalInscripciones() {
        List<Evento> eventos = eventoRepository.findAll();
        Float valorTotalInscripciones = 0.0f;

        for (Evento evento : eventos) {
            List<Inscripcion> inscripciones = inscripcionRepository.findByEventoId(evento.getId());

            for (Inscripcion inscripcion : inscripciones) {
                valorTotalInscripciones += inscripcion.getValor();
            }
        }

        return valorTotalInscripciones;
    }
}
