package com.example.chamada.model;

import com.example.chamada.model.aluno.Aluno;
import com.example.chamada.model.chamada.Chamada;
import jakarta.persistence.*;

@Entity
public class AlunoChamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean presente;

    @ManyToOne
    @JoinColumn(name = "ChamadaID")
    private Chamada chamada;

    @ManyToOne
    @JoinColumn(name = "AlunoID")
    private Aluno aluno;

    public AlunoChamada() {
    }

    public AlunoChamada(boolean presente, Chamada chamada, Aluno aluno) {
        this.presente = presente;
        this.chamada = chamada;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Chamada getChamada() {
        return chamada;
    }

    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
