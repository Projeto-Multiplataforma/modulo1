package br.com.fatec.pessoa.repository;

import br.com.fatec.pessoa.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaRepository {
    Pessoa save(Pessoa pessoa);

    Pessoa findByIDAndATIVOTrue(String id);

    Page<Pessoa> findByATIVOTrue(Pageable pageable);

    void delete(String id);
}
