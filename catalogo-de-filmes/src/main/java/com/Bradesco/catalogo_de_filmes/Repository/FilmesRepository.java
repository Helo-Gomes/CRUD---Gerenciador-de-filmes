package com.Bradesco.catalogo_de_filmes.Repository;


import com.Bradesco.catalogo_de_filmes.Entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
// Parâmetros: <Entidade, TipoDoId>
public interface FilmesRepository extends JpaRepository <Filmes, Long>{

    Optional<Filmes> findById(Long id);

    List<Filmes> findByNome(String nome);

    List<Filmes> findByGenero(String genero);

    List<Filmes> findByDiretor(String diretor);

    List<Filmes> findByNota(Integer nota);

    //JPA --> WHERE data_lancamento BETWEEN ? AND ?
    List<Filmes> findByDataLancamentoBetween(LocalDate dataInicio, LocalDate dataFim);

}
