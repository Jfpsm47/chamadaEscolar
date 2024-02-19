package com.example.chamada.model.aluno;

import java.util.List;

import com.example.chamada.model.AlunoChamada;
import com.example.chamada.model.chamada.Chamada;
import com.example.chamada.model.turma.Turma;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "turmaID")
	private Turma turma;

	@OneToMany(mappedBy = "aluno")
	@JsonIgnore
	private List<AlunoChamada> alunoChamada;

	public Aluno() {
		super();
	}

	public Aluno(String nome, Turma turma) {
		super();
		this.nome = nome;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
