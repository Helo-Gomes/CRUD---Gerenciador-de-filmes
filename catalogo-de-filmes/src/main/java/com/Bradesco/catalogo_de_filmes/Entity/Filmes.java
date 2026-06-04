package com.Bradesco.catalogo_de_filmes.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "filmes")
public class Filmes {

    @Id
    // o banco gera o ID automaticamente (auto increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String genero;

    @NotBlank
    private String diretor;

    @NotBlank @Min(1) @Max(5)
    private Integer nota;


    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy")
    @PastOrPresent //verifica se data é somente no passado ou presente
    private LocalDate dataLancamento;


    //GETTERS/SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
//Metodos especiais

    @Transient
    public String getClassificacao(){
        return switch (nota) {
            case 5 -> "Absolute Cinema!";
            case 4 -> "Excelente";
            case 3 -> "Bom!";
            case 2 -> "Ok!";
            case 1 -> "Esse é ruim demais!";
            default -> "Nota inválida";
        };
    }


}
