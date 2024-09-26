package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Vagas")
public class Vaga {

    @Id
    @GeneratedValue
    @Column(name = "vagaid")
    private int vagaId;

    @NotBlank
    @Column(name = "nome")
    @NotEmpty
    private String nome;

    @NotBlank
    @Column(name = "descricao")
    @NotEmpty
    private String descricao;

    @NotBlank
    @Column(name = "data")
    @NotEmpty
    private LocalDateTime data;

    @OneToMany(mappedBy = "Vagas", cascade = CascadeType.REMOVE)
    private List<Candidato> candidatos;

}
