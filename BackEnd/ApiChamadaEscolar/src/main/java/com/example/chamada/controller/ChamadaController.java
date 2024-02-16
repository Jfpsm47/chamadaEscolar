package com.example.chamada.controller;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.aluno.AlunoPresenca;
import com.example.chamada.model.chamada.AlunoPresencaDTO;
import com.example.chamada.model.chamada.Chamada;
import com.example.chamada.model.chamada.ChamadaDTO;
import com.example.chamada.model.turma.Turma;
import com.example.chamada.repository.AlunoPresencaRepository;
import com.example.chamada.repository.AlunoRepository;
import com.example.chamada.repository.ChamadaRepository;
import com.example.chamada.repository.TurmaRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    AlunoPresencaRepository alunoPresencaRepository;


    @PostMapping("/cadastrar/{turmaID}")
    public void addChamada(@PathVariable Long turmaID, @RequestBody List<AlunoPresencaDTO> alunos)  {
        Optional<Turma> turma = turmaRepository.findById(turmaID);
        alunos.forEach(alunoPresencaDTO -> {
            Aluno aluno  = alunoRepository.findByNome(alunoPresencaDTO.nome());
            AlunoPresenca alunoPresenca = new AlunoPresenca(alunoPresencaDTO.presenca(),aluno);
            alunoPresencaRepository.save(alunoPresenca);
            Chamada chamada = new Chamada("teste",alunoPresencaDTO.presenca(),turma.get());
            repository.save(chamada);
        });
    }
    @GetMapping("/listar")
    public ResponseEntity listarChamadas(){
        return ResponseEntity.ok(repository.findAll());
    }
}
