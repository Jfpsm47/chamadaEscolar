package com.example.chamada.model.chamada;

public class AlunoPresencaDTO {
    private String nome;
    private boolean presensa;

    public AlunoPresencaDTO() {
    }

    public AlunoPresencaDTO(String nome, boolean presensa) {
        this.nome = nome;
        this.presensa = presensa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPresensa() {
        return presensa;
    }

    public void setPresensa(boolean presensa) {
        this.presensa = presensa;
    }
}
