package com.brt.brt_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brt.brt_backend.dto.AutocarroDTO;
import com.brt.brt_backend.model.Autocarro;
import com.brt.brt_backend.service.AutocarroService;


@RestController
@RequestMapping("/autocarros")
@CrossOrigin(origins = "http://localhost:3000") // Permite chamadas do React
public class AutocarroController {

    private final AutocarroService autocarroService;

    public AutocarroController(AutocarroService autocarroService) {
        this.autocarroService = autocarroService;
    }

    @GetMapping
    public List<AutocarroDTO> listarAutocarros() {
        return autocarroService.listarAutocarros();
    }

    @PostMapping
    public ResponseEntity<AutocarroDTO> adicionarAutocarro(@RequestBody Autocarro autocarro) {
        return ResponseEntity.ok(autocarroService.adicionarAutocarro(autocarro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutocarroDTO> atualizarAutocarro(@PathVariable Long id, @RequestBody Autocarro autocarroAtualizado) {
        Optional<AutocarroDTO> atualizado = autocarroService.atualizarAutocarro(id, autocarroAtualizado);
        return atualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAutocarro(@PathVariable Long id) {
        if (autocarroService.removerAutocarro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/entrar/{quantidade}")
    public ResponseEntity<Void> entrarPassageiros(@PathVariable Long id, @PathVariable int quantidade) {
        autocarroService.entrarPassageiros(id, quantidade);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/sair/{quantidade}")
    public ResponseEntity<Void> sairPassageiros(@PathVariable Long id, @PathVariable int quantidade) {
        autocarroService.sairPassageiros(id, quantidade);
        return ResponseEntity.ok().build();
    }
}





