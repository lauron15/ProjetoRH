package com.AppRh.AppRh.Controller;

import com.AppRh.AppRh.Model.Candidato;

import com.AppRh.AppRh.Model.Usuario;
import com.AppRh.AppRh.Service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidato")
@CrossOrigin("*")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }


    @GetMapping
    public ResponseEntity<List<Candidato>> listarCandidatos() {
        List<Candidato> candidatoes = candidatoService.listarCandidatos();
        return ResponseEntity.status(200).body(candidatoes);
    }


    //
    @GetMapping("/{id}")
    public ResponseEntity<Candidato> listarCandidatosPorId(@PathVariable Integer id) {
        Optional<Candidato> candidato = candidatoService.listarCandidatosPorId(id);
        return candidato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Candidato> criarCandidato(@RequestBody Candidato candidato) {
        return ResponseEntity.status(201).body(candidatoService.criarCandidato(candidato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> editarCandidato(@RequestBody Candidato candidato, @PathVariable Integer id) {
        return ResponseEntity.status(200).body(candidatoService.editarCandidato(candidato, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidato> editarCandidato(@PathVariable Integer id) {
        candidatoService.excluirCandidato(id);
        return ResponseEntity.status(204).build();
    }

}
