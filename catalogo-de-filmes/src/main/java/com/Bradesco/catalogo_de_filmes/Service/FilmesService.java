package com.Bradesco.catalogo_de_filmes.Service;


import com.Bradesco.catalogo_de_filmes.Entity.Filmes;
import com.Bradesco.catalogo_de_filmes.Repository.FilmesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilmesService {

    //Classe que contem as regras de negocio

    //Injeção por construtor sem autowired
    private final FilmesRepository repository;


    public FilmesService(FilmesRepository repository) {
        this.repository = repository;
    }

    //CREATE--------------------------------------------
    public Filmes criar(Filmes filme){
        return repository.save(filme);
    }

    //READ----------------------------------------------

    //busca todos
    public List<Filmes> listarTodos(){
        return repository.findAll();
    }
    //busca por id
    public Filmes buscaPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("Filme com id" + id +" não encontrado."));
    }
    //busca por nome
    public List<Filmes> buscaPorNome(String nome){
        return repository.findByNome(nome);
    }

    //busca por genero
    public List<Filmes> buscaPorGenero(String genero){
        return repository.findByGenero(genero);
    }

    //busca por diretor
    public List<Filmes> buscaPorDiretor(String diretor){
        return repository.findByDiretor(diretor);
    }

    //busca por nota
    public List<Filmes> buscaPorNota(Integer nota){
        return repository.findByNota(nota);
    }

    //buscar por data
    public List<Filmes> buscaPorDataLancamento(LocalDate dataInicio, LocalDate dataFim){
        return repository.findByDataLancamentoBetween(dataInicio,dataFim);
    }

    //UPDATE
    public Filmes atualizar(Long id, Filmes dados){
        //atualizar filme pelo id
        Filmes filmeExistente = buscaPorId(id);
        filmeExistente.setNome(dados.getNome());
        filmeExistente.setGenero(dados.getGenero());
        filmeExistente.setDiretor(dados.getDiretor());
        filmeExistente.setNota(dados.getNota());

        return repository.save(filmeExistente);
    }

    //DELETE
    public void deletar(Long id){
        buscaPorId(id);
        repository.deleteById(id);
    }
}
