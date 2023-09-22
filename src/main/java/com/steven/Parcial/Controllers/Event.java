package com.steven.Parcial.Controllers;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Service.ActividadService;
import com.steven.Parcial.Service.EventoService;
import com.steven.Parcial.Service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class Event {
    @Autowired
    private EventoService eventoService;
    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventoService.crearEvento(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoService.listarEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);

    }




}