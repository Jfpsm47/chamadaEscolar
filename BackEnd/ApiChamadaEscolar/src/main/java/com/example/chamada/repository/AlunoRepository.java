package com.example.chamada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chamada.model.aluno.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
