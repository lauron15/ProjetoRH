package com.AppRh.AppRh.Service;

import com.AppRh.AppRh.Model.Candidato;
import com.AppRh.AppRh.Repository.ICandidato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {


    private final ICandidato repository;

    public CandidatoService(ICandidato repository) {
        this.repository = repository;
    }

    public List<Candidato> listarCandidatos() {
        return repository.findAll();
    }

    public Optional<Candidato> listarCandidatosPorId(Integer id) {
        return repository.findById(id);
    }

    public Candidato criarCandidato(Candidato candidato) {
        return repository.save(candidato);
    }

    public Candidato editarCandidato(Candidato candidato, Integer id) {
        Optional<Candidato> candidatoExistente = repository.findById(id);
        if (candidatoExistente.isPresent()) {
            candidato.setId(id);
            return repository.save(candidato);
        } else {
            throw new RuntimeException("Candidato com o ID" + id + "não encontrado");
        }
    }

    public Boolean excluirCandidato(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Candidato com ID " + id + " não encontrado.");
        }
    }

}
