package com.AppRh.AppRh.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "O RG é obrigatório")
    @Column(name = "rg", unique = true)
    private String rg;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nomecandidato")
    private String nomeCandidato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vagaid")
    private Vaga vaga;
}
