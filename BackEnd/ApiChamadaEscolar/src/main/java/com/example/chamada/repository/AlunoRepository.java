package com.example.chamada.repository;

import com.example.chamada.model.turma.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chamada.model.aluno.Aluno;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
Aluno findByNome(String nome);
List<Aluno>findByTurma(Turma turma);

}
