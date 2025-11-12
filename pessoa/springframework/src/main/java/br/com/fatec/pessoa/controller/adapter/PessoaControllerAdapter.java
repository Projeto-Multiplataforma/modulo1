package br.com.fatec.pessoa.controller.adapter;

import br.com.fatec.pessoa.controller.dto.request.PessoaRequest;
import br.com.fatec.pessoa.controller.dto.response.PessoaResponse;
import br.com.fatec.pessoa.entity.Pessoa;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaControllerAdapter {
    private PessoaControllerAdapter(){}

    public static PessoaResponse cast(Pessoa pessoa){
        return new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dataNascimento()
        );
    }

    public static List<PessoaResponse> cast(List<Pessoa> pessoas){
        List<PessoaResponse> pessoasResponse = new ArrayList<PessoaResponse>();

        for (int i = 0; i < pessoas.size(); i++) {
            pessoasResponse.add(new PessoaResponse(
                    pessoas.get(i).id(),
                    pessoas.get(i).nome(),
                    pessoas.get(i).dataNascimento()
            ));
        }

        return pessoasResponse;
    }

    public static Page<PessoaResponse> cast(Page<Pessoa> pessoas) {
        return pessoas.map(pessoaOrm ->
                new PessoaResponse(
                        pessoaOrm.id(),
                        pessoaOrm.nome(),
                        pessoaOrm.dataNascimento()
                )
        );
    }

    public static Pessoa cast(PessoaRequest pessoa){
        return new Pessoa(
                UUID.randomUUID().toString(),
                pessoa.nome(),
                pessoa.dataNascimento(),
                true
        );
    }

    public static Pessoa cast(PessoaRequest request, String id){
        return new Pessoa(
                id,
                request.nome(),
                request.dataNascimento(),
                true
        );
    }

}
