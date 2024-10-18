package com.AppRh.AppRh.Repository;

import com.AppRh.AppRh.Model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICandidato extends JpaRepository<Candidato, Integer> {
    List<Candidato> findByRg(String rg);
}
