package com.steven.Parcial.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Inscripcion() {
    }

    public Inscripcion(Long id, Float valor, Participante participante, Evento evento) {
        this.id = id;
        this.valor = valor;
        this.participante = participante;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
