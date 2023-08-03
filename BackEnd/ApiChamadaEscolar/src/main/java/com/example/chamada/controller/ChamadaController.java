package com.example.chamada.controller;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.chamada.AlunoPresencaDTO;
import com.example.chamada.model.chamada.Chamada;
import com.example.chamada.model.chamada.ChamadaDTO;
import com.example.chamada.model.turma.Turma;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/chamada")
public class ChamadaController {
    @Autowired
    ChamadaRepository repository;
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping("/cadastrar/{turmaID}")
    public ResponseEntity addChamada(@RequestBody ArrayList<AlunoPresencaDTO> listAlunoPresenca, @PathVariable Long turmaID) throws ParseException {
        Random generator = new Random();
        Long idGrupo = generator.nextLong();
        for (AlunoPresencaDTO alunoPresenca: listAlunoPresenca) {
            Aluno aluno = alunoRepository.findByNome(alunoPresenca.nome());
            Turma turma = turmaRepository.findById(turmaID).get();
            Date date = new Date();
            String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);

            Chamada chamada = new Chamada(dateFormat,alunoPresenca.presenca(),idGrupo,turma,aluno);

            repository.save(chamada);
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public ResponseEntity listarChamadas(){
        return ResponseEntity.ok(repository.findAll());
    }
}
