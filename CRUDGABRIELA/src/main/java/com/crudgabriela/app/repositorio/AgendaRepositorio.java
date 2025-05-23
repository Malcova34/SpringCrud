package com.crudgabriela.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudgabriela.app.entidades.Agenda;

public interface AgendaRepositorio extends JpaRepository<Agenda, Long> {

}
