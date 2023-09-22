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



    public Participante crearParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }
}
