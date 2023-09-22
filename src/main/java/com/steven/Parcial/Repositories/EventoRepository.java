package com.steven.Parcial.Repositories;

import com.steven.Parcial.Entities.Actividad;
import com.steven.Parcial.Entities.Evento;
import com.steven.Parcial.Entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {


}
