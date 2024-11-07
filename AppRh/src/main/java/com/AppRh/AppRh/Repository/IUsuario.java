package com.AppRh.AppRh.Repository;

import com.AppRh.AppRh.Model.Candidato;
import com.AppRh.AppRh.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuario extends JpaRepository<Usuario,Integer> {

    List<Usuario> findById(int id);
}
