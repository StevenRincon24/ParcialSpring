package com.steven.Parcial.Controllers;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<Actividad> listarActividades() {
        return actividadService.listarActividades();
    }


    @PostMapping
    public Actividad crearActividad(@RequestBody Actividad actividad) {
        return actividadService.crearActividad(actividad);
    }


}
