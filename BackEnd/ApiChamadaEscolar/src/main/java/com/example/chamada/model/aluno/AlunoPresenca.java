package com.example.chamada.model.aluno;

import com.example.chamada.model.chamada.Chamada;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AlunoPresenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AlunopPresencaID;

    private boolean presenca;

    @ManyToOne
    @JoinColumn(name = "alunoID")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "chamadaID")
    private Chamada chamadas;

    public AlunoPresenca() {
    }

    public AlunoPresenca(boolean presenca, Aluno aluno) {
        this.presenca = presenca;
        this.aluno = aluno;
    }

    public Long getAlunopPresencaID() {
        return AlunopPresencaID;
    }

    public void setAlunopPresencaID(Long alunopPresencaID) {
        AlunopPresencaID = alunopPresencaID;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
