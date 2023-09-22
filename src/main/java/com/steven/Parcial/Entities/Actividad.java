package com.steven.Parcial.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private LocalDate fecha;
    @Column
    private String tipo; // Puede ser "Conferencia", "Ponencia" o "Taller"

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonIgnoreProperties("evento")
    private Evento evento;
    @ManyToOne
    @JoinColumn(name = "participante_id")
    @JsonIgnoreProperties("evento")
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Actividad() {
    }

    public Actividad(Long id, String nombre, LocalDate fecha, String tipo, Evento evento) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
