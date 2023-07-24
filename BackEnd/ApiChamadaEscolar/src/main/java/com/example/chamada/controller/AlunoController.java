package com.example.chamada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.aluno.AlunoDTO;
import com.example.chamada.model.turma.Turma;
import com.example.chamada.repository.AlunoRepository;
import com.example.chamada.repository.TurmaRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	AlunoRepository repository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@GetMapping("/listar")
	public ResponseEntity listar() {
		if (repository.findAll().isEmpty()) return ResponseEntity.badRequest().body("Nenhum aluno cadastrado ainda!");
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar(@RequestBody AlunoDTO data ) {
		Turma turma = turmaRepository.findById(data.turmaID()).get();	
		Aluno aluno = new Aluno(data.nome(),turma);
		
		repository.save(aluno);
		
		return ResponseEntity.ok().build();
	}
}
