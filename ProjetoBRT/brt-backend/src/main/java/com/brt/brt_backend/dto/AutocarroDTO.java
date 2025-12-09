package com.brt.brt_backend.dto;

public class AutocarroDTO {
    private Long id;
    private String matricula;
    private int capacidadeMaxima;
    private int passageirosAtuais;

    // Construtor
    public AutocarroDTO(Long id, String matricula, int capacidadeMaxima, int passageirosAtuais) {
        this.id = id;
        this.matricula = matricula;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageirosAtuais = passageirosAtuais;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getPassageirosAtuais() {
        return passageirosAtuais;
    }

    public void setPassageirosAtuais(int passageirosAtuais) {
        this.passageirosAtuais = passageirosAtuais;
    }
}

