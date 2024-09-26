package Controller;


import Model.Vaga;
import Service.VagaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/vaga")
public class VagaController {

    private final VagaService vagaService;
    public VagaController (VagaService vagaService) {
        this.vagaService= vagaService;
    }

    //Buscar
    @GetMapping
    public ResponseEntity<List<Vaga>>listarVagas(){
        return ResponseEntity.status(200).body(vagaService.listarVagas());
    }
    //BuscarPorId
    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarVagaPorid(@PathVariable Integer id){
        Optional<Vaga>vaga = vagaService.buscarVagaPorid(id);
        return vaga.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //Cadastrar
    @PostMapping
    public ResponseEntity<Vaga>cadastrarVaga(@Valid @RequestBody Vaga vaga){
return ResponseEntity.status(201).body(vagaService.cadastrarVaga(vaga));
    }
    //Editar
    @PutMapping("/{id}")
    public  ResponseEntity<Vaga>editarVaga(@Valid @RequestBody Vaga vaga, @PathVariable Integer id){
        return ResponseEntity.status(200).body(vagaService.editarVaga(vaga, id));
    }

    //Deletar
    @DeleteMapping("/{id}")
    public  ResponseEntity<Vaga>deletarVaga(@PathVariable Integer id){
        vagaService.excluirVaga(id);
        return ResponseEntity.status(204).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    // Adotar o uso desse methodo abaixo para capturar os erros.
    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}
