package com.AppRh.AppRh.Controller;


import com.AppRh.AppRh.Model.Usuario;
import com.AppRh.AppRh.Service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuariosPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.listarUsuariosPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.cadastrarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable Integer id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }
}
