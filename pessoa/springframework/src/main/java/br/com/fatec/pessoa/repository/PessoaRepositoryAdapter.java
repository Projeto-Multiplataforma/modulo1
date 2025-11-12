package br.com.fatec.pessoa.repository;

import br.com.fatec.pessoa.entity.Pessoa;
import br.com.fatec.pessoa.repository.orm.PessoaOrm;
import org.springframework.data.domain.Page;

public class PessoaRepositoryAdapter {
    private PessoaRepositoryAdapter(){}

    public static PessoaOrm cast(Pessoa pessoa){
        return new PessoaOrm(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dataNascimento(),
                pessoa.ativo()
        );
    }

    public static Pessoa cast(PessoaOrm pessoa){
        return new Pessoa(
                pessoa.ID(),
                pessoa.NAME(),
                pessoa.DT_NASCIMENTO(),
                pessoa.ATIVO()
        );
    }

    public static Page<Pessoa> cast(Page<PessoaOrm> pessoasOrm) {
        return pessoasOrm.map(pessoaOrm ->
                new Pessoa(
                        pessoaOrm.ID(),
                        pessoaOrm.NAME(),
                        pessoaOrm.DT_NASCIMENTO(),
                        pessoaOrm.ATIVO()
                )
        );

    }

}
