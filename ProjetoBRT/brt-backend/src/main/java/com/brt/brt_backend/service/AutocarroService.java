package com.brt.brt_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brt.brt_backend.dto.AutocarroDTO;
import com.brt.brt_backend.model.Autocarro;
import com.brt.brt_backend.repository.AutocarroRepository;

@Service
public class AutocarroService {

    private final AutocarroRepository autocarroRepository;

    public AutocarroService(AutocarroRepository autocarroRepository) {
        this.autocarroRepository = autocarroRepository;
    }

    public List<AutocarroDTO> listarAutocarros() {
        return autocarroRepository.findAll().stream()
            .map(a -> new AutocarroDTO(a.getId(), a.getMatricula(), a.getCapacidadeMaxima(), a.getPassageirosAtuais()))
            .collect(Collectors.toList());
    }

    public AutocarroDTO adicionarAutocarro(Autocarro autocarro) {
        Autocarro novoAutocarro = autocarroRepository.save(autocarro);
        return new AutocarroDTO(novoAutocarro.getId(), novoAutocarro.getMatricula(), novoAutocarro.getCapacidadeMaxima(), novoAutocarro.getPassageirosAtuais());
    }

    public Optional<AutocarroDTO> atualizarAutocarro(Long id, Autocarro autocarroAtualizado) {
        return autocarroRepository.findById(id).map(autocarro -> {
            autocarro.setMatricula(autocarroAtualizado.getMatricula());
            autocarro.setCapacidadeMaxima(autocarroAtualizado.getCapacidadeMaxima());
            autocarro.setPassageirosAtuais(autocarroAtualizado.getPassageirosAtuais());
            autocarroRepository.save(autocarro);
            return new AutocarroDTO(autocarro.getId(), autocarro.getMatricula(), autocarro.getCapacidadeMaxima(), autocarro.getPassageirosAtuais());
        });
    }

    public boolean removerAutocarro(Long id) {
        if (autocarroRepository.existsById(id)) {
            autocarroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void entrarPassageiros(Long id, int quantidade) {
        autocarroRepository.findById(id).ifPresent(autocarro -> {
            int novosPassageiros = autocarro.getPassageirosAtuais() + quantidade;
            if (novosPassageiros <= autocarro.getCapacidadeMaxima()) {
                autocarro.setPassageirosAtuais(novosPassageiros);
                autocarroRepository.save(autocarro);
            }
        });
    }

    public void sairPassageiros(Long id, int quantidade) {
        autocarroRepository.findById(id).ifPresent(autocarro -> {
            int novosPassageiros = autocarro.getPassageirosAtuais() - quantidade;
            if (novosPassageiros >= 0) {
                autocarro.setPassageirosAtuais(novosPassageiros);
                autocarroRepository.save(autocarro);
            }
        });
    }
}








