package com.AppRh.AppRh.Service;


import com.AppRh.AppRh.Model.Usuario;
import com.AppRh.AppRh.Repository.IUsuario;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> listarUsuariosPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario, Integer id) {
        Optional<Usuario> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return repository.save(usuario);
        } else {
            throw new RuntimeException("Usuario com o ID" + id + "não encontrado");
        }
    }

    public Boolean excluirUsuario(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Usuario com o Id" + id + "não encontrado.");
        }
    }

}

