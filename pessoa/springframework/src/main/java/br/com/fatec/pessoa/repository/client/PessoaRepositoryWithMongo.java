package br.com.fatec.pessoa.repository.client;

import br.com.fatec.pessoa.repository.orm.PessoaOrm;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositoryWithMongo extends MongoRepository<PessoaOrm, String> {
    Optional<PessoaOrm> findByIDAndATIVOTrue(String id);
    Page<PessoaOrm> findByATIVOTrue(Pageable pageable);

}
