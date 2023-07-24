package com.example.chamada.model.chamada;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.turma.Turma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	private boolean presenca;
	private int identificadorGrupo;
	
	@ManyToOne
	@JoinColumn(name = "turmaID")
	private Turma turma;
	
	
	@ManyToOne
	@JoinColumn(name = "alunoID")
	private Aluno aluno;


	
	public Chamada() {
		super();
	}


	public Chamada(String data, boolean presenca, int identificadorGrupo, Turma turma, Aluno aluno) {
		super();
		this.data = data;
		this.presenca = presenca;
		this.identificadorGrupo = identificadorGrupo;
		this.turma = turma;
		this.aluno = aluno;
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


	public int getIdentificadorGrupo() {
		return identificadorGrupo;
	}


	public void setIdentificadorGrupo(int identificadorGrupo) {
		this.identificadorGrupo = identificadorGrupo;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
