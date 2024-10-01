package Controller;

import Model.Vaga;
import Service.VagaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/vaga")
@CrossOrigin("*")

public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }
    @GetMapping
    public ResponseEntity<List<Vaga>> listarVaga() {
        List<Vaga> vaga = vagaService.listarVaga();
        return ResponseEntity.status(200).body(vaga);
    }

    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

