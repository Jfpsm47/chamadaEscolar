package com.example.chamada.controller;

import ch.qos.logback.core.model.Model;
import com.example.chamada.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.chamada.model.turma.Turma;
import com.example.chamada.model.turma.TurmaDTO;
import com.example.chamada.repository.TurmaRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	TurmaRepository repository;
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listarTurma");
		mv.addObject("turmas",repository.findAll());
		return mv;
	}
	@GetMapping("/listar/{id}")
	public ModelAndView listarTurma(@PathVariable Long id){
		Turma turma = repository.findById(id).get();
		ModelAndView mv = new ModelAndView("alunosTurma");
		mv.addObject("turma",repository.findById(id).get());
		mv.addObject("alunos",alunoRepository.findByTurma(turma));

		return mv;
	}
	@GetMapping("/cadastrar")
	public String homeCadastrar(){
		return "cadastrarTurma";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(TurmaDTO data) {
		Turma turma = new Turma(data.nome(),data.turno());
		repository.save(turma);
		
		return "redirect:/turma/listar";
	}
}
