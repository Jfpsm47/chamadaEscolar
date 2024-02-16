package com.example.chamada.repository;

import com.example.chamada.model.aluno.AlunoPresenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoPresencaRepository extends JpaRepository <AlunoPresenca, Long> {
}
