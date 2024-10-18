package com.AppRh.AppRh.Repository;

import com.AppRh.AppRh.Model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVaga extends JpaRepository<Vaga, Integer> {
    List<Vaga> findByVagaId(Integer VagaId);
}
