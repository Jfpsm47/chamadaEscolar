package com.example.chamada.model.chamada;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.aluno.AlunoPresenca;
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
	private boolean presenca;
	private Long identificadorGrupo;
	
	@ManyToOne
	@JoinColumn(name = "turmaID")
	private Turma turma;
	
	
	@OneToMany(mappedBy = "chamadas")
	@JsonIgnore
	private List<AlunoPresenca> alunoPresenca;


	
	public Chamada() {
		super();
	}


	public Chamada(String data, boolean presenca, Turma turma) {
		super();
		this.data = data;
		this.presenca = presenca;
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


	public boolean isPresenca() {
		return presenca;
	}


	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}


	public Long getIdentificadorGrupo() {
		return identificadorGrupo;
	}


	public void setIdentificadorGrupo(Long identificadorGrupo) {
		this.identificadorGrupo = identificadorGrupo;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public List<AlunoPresenca> getAluno() {
		return alunoPresenca;
	}


	public void setAluno(List<AlunoPresenca> aluno) {
		this.alunoPresenca = aluno;
	}
	
	
}
