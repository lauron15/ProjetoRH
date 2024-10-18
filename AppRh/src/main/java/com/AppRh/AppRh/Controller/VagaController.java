package com.AppRh.AppRh.Controller;

import com.AppRh.AppRh.Model.Vaga;
import com.AppRh.AppRh.Service.VagaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/vaga")
@CrossOrigin("*")

public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarVaga() {
        return ResponseEntity.status(200).body(vagaService.listarVaga());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarVagaPorId(@PathVariable Integer id) {
        Optional<Vaga> vaga = vagaService.buscarVagaPorId(id);
        return vaga.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Vaga> cadastrarVaga(Vaga vaga) {
        return ResponseEntity.status(201).body(vagaService.cadastrarVaga(vaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> editarVaga(@RequestBody Vaga vaga, @PathVariable Integer id) {

        return ResponseEntity.status(200).body(vagaService.editarVaga(vaga, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vaga> excluirVaga(@PathVariable Integer id) {
        vagaService.excluirVaga(id);
        return ResponseEntity.status(204).build();
    }


    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

