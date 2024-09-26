package Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotBlank(message = "O RG é obrigatório")
    @Column(name = "RG", unique = true)
    private String Rg;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nomeCandidato")
    @NotEmpty
    private String nomeCandidato;

    @ManyToOne
    private Vaga vaga;

}
