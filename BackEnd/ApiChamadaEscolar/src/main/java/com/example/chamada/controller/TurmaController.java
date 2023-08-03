package com.example.chamada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.chamada.model.turma.Turma;
import com.example.chamada.model.turma.TurmaDTO;
import com.example.chamada.repository.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	TurmaRepository repository;
	
	@GetMapping("/listar")
	public ResponseEntity listar() {
		if (repository.findAll().isEmpty()) return ResponseEntity.badRequest().body("Nenhuma turma cadastrada ainda!");
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/cadastrar")
	public String homeCadastrar(){
		return "cadastrarTurma";
	}
	@PostMapping("/cadastrar")
	public String cadastrar(TurmaDTO data) {
		Turma turma = new Turma(data.nome(),data.turno());
		repository.save(turma);
		
		return "redirect:/turma/cadastrar";
	}
}
