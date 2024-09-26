package Repository;

import Model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVaga extends JpaRepository<Vaga, Integer> {
    List<Vaga> findByVagaid(Integer VagaId);
}
