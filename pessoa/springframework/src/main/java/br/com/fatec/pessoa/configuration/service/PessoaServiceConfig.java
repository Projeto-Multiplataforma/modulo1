package br.com.fatec.pessoa.configuration.service;

import br.com.fatec.pessoa.repository.PessoaRepository;
import br.com.fatec.pessoa.service.PessoaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaServiceConfig {
    @Bean
    public PessoaService pessoaService(PessoaRepository repository){
        return new PessoaService(repository);
    }
}
