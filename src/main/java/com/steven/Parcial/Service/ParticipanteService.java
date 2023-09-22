package com.steven.Parcial.Service;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.NotFoundException;
import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Actividad> obtenerAgendaDelParticipanteEnEvento(Long participanteId, Long eventoId) {
        Optional<Participante> participanteOptional = participanteRepository.findById(participanteId);

        if (participanteOptional.isPresent()) {
            Participante participante = participanteOptional.get();
            List<Evento> eventosDelParticipante = participante.getEventos();

            // Buscar el evento específico por su ID
            Optional<Evento> eventoOptional = eventosDelParticipante.stream()
                    .filter(evento -> evento.getId().equals(eventoId))
                    .findFirst();

            if (eventoOptional.isPresent()) {
                Evento evento = eventoOptional.get();
                return evento.getActividades();
            } else {
                throw new NotFoundException("Evento no encontrado con ID: " + eventoId);
            }
        } else {
            throw new NotFoundException("Participante no encontrado con ID: " + participanteId);
        }
    }

    public Participante crearParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }
}
