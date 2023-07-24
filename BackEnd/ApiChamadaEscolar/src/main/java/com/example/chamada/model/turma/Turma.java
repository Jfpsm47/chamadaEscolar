package com.example.chamada.model.turma;

import java.util.List;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.chamada.Chamada;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String turno;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private List<Chamada> chamadas;

	public Turma() {
		super();
	}

	public Turma(String nome, String turno) {
		super();
		this.nome = nome;
		this.turno = turno;
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
