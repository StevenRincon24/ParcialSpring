package com.steven.Parcial.Service;

import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.NotFoundException;
import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventoService {
    private final EventoRepository eventoRepository;


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




}
