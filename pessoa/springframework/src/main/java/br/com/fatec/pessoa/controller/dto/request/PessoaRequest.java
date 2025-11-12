package br.com.fatec.pessoa.controller.dto.request;

import java.time.LocalDate;

public record PessoaRequest(
        String nome,
        LocalDate dataNascimento
) {
}
