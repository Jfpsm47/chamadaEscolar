package com.example.chamada.model.chamada;

import com.example.chamada.model.AlunoChamada;
import com.example.chamada.model.turma.Turma;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chamada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	
	@ManyToOne
	@JoinColumn(name = "turmaID")
	private Turma turma;

	@OneToMany(mappedBy = "chamada")
	@JsonIgnore
	List<AlunoChamada> alunoChamada;

	public Chamada() {
		super();
	}


	public Chamada(String data, Turma turma) {
		this.data = data;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	
}
