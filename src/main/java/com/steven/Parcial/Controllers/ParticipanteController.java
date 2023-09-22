package com.steven.Parcial.Controllers;

import com.steven.Parcial.Entities.Participante;
import com.steven.Parcial.Service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<Participante> crearParticipante(@RequestBody Participante participante) {
        Participante nuevoParticipante = participanteService.crearParticipante(participante);
        return new ResponseEntity<>(nuevoParticipante, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Participante>> listarParticipantes() {
        List<Participante> participantes = participanteService.listarParticipantes();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }
}
