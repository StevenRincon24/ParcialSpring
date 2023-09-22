package com.steven.Parcial.Service;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> obtenerAgendaDelParticipante(Long participanteId, Long eventoId) {
        return actividadRepository.findByEventoIdAndParticipanteId(eventoId, participanteId);
    }

    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }
}
