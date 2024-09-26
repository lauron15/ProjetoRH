package Controller;

import Model.Vaga;
import Service.VagaService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@CrossOrigin("*")
@RequestMapping("/Vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }
    @GetMapping
    public ResponseEntity<List<Vaga>> listarVagas() {
        return ResponseEntity.status(200).body(vagaService.listarVagas());
    }

}

