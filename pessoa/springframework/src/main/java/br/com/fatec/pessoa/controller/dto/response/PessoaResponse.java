package br.com.fatec.pessoa.controller.dto.response;

import java.time.LocalDate;

public record PessoaResponse(
        String id,
        String nome,
        LocalDate dataNascimento
) {
}
