package Service;

import Model.Vaga;
import Repository.IVaga;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    private final IVaga repository;

    public VagaService(IVaga repository){
        this.repository = repository;
    }

    public List<Vaga>listarVagas(){
        return repository.findAll();
    }

    public Optional<Vaga> buscarVagaPorid(Integer id){
        return repository.findById(id);
    }
 public Vaga cadastrarVaga(Vaga vaga){
        return repository.save(vaga);
 }

 public Vaga editarVaga(Vaga vaga, Integer id) {
     Optional<Vaga> vagaExistente = repository.findById(id);
     if (vagaExistente.isPresent()) {
         vaga.setVagaId(id);
         return repository.save(vaga);
     } else {
         throw new RuntimeException("A vaga com o ID" + id + "não foi encontrada.");

     }
 }

 public Boolean excluirVaga(Integer id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Vaga com a ID" + id + "não encontrada.");
        }
 }

}
