package br.com.fatec.pessoa.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("pessoa")
public record PessoaOrm(
    @Id
    String ID,
    String NAME,
    LocalDate DT_NASCIMENTO,
    boolean ATIVO
) {
}
