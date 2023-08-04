package com.example.chamada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chamada.model.turma.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    Turma findByNome(String nome);
}
