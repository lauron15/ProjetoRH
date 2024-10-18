package com.AppRh.AppRh.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vagaid")
    private int vagaId;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    // Mapeamento corrigido para "vaga"
    @OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Candidato> candidatos;
}
