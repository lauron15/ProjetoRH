package Service;

import Model.Vaga;
import Repository.IVaga;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VagaService {

    private final IVaga repository;

    public VagaService(IVaga repository) {
        this.repository = repository;
    }

    public List<Vaga> listarVaga() {
        return repository.findAll();
    }

    public Vaga buscarVagaPorId(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Vaga com ID " + id + " não encontrada."));
    }

    public Vaga cadastrarVaga(Vaga vaga) {
        return repository.save(vaga);
    }

    public Vaga editarVaga(Vaga vaga, Integer id) {
        vaga.setVagaId(id);
        return repository.findById(id).map(existingVaga -> repository.save(vaga))
                .orElseThrow(() -> new RuntimeException("A vaga com ID " + id + " não foi encontrada."));
    }

    public Boolean excluirVaga(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Vaga com ID " + id + " não encontrada.");
        }
    }
}
