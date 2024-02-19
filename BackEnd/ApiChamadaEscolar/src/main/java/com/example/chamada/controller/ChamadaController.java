package com.example.chamada.controller;

import com.example.chamada.model.AlunoChamada;
import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.chamada.AlunoPresencaDTO;
import com.example.chamada.model.chamada.Chamada;
import com.example.chamada.model.turma.Turma;
import com.example.chamada.repository.AlunoChamadaRepository;
import com.example.chamada.repository.AlunoRepository;
import com.example.chamada.repository.ChamadaRepository;
import com.example.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/chamada")
public class ChamadaController {
    @Autowired
    ChamadaRepository repository;
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoChamadaRepository alunoChamadaRepository;


    @PostMapping("/cadastrar/{turmaID}")
    public void addChamada(@PathVariable Long turmaID, @RequestBody List<AlunoPresencaDTO> alunos)  {
        Optional<Turma> turma = turmaRepository.findById(turmaID);
        Chamada chamada = new Chamada("teste",turma.get());
        repository.save(chamada);
        for (AlunoPresencaDTO aluno: alunos){
            Aluno data = alunoRepository.findByNome(aluno.nome());
            AlunoChamada alunoChamada = new AlunoChamada(aluno.presenca(), chamada, data);
            alunoChamadaRepository.save(alunoChamada);
        }
    }
}
