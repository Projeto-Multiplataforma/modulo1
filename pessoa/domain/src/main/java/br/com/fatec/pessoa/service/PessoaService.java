package br.com.fatec.pessoa.service;

import br.com.fatec.pessoa.entity.Pessoa;
import br.com.fatec.pessoa.repository.PessoaRepository;

public class PessoaService {
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public Pessoa save(Pessoa pessoa){
        return repository.save(pessoa);
    }
}
