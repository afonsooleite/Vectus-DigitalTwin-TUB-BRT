package com.brt.brt_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autocarros")
public class Autocarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private int capacidadeMaxima;
    private int passageirosAtuais;

    public Autocarro() {}

    public Autocarro(Long id, String matricula, int capacidadeMaxima, int passageirosAtuais) {
        this.id = id;
        this.matricula = matricula;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageirosAtuais = passageirosAtuais;
    }    

    // Getters e Setters
    public Long getId() {
        return id;
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

