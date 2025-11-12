package br.com.fatec.pessoa.entity;

import java.time.LocalDate;

public record Pessoa (
    String id,
    String nome,
    LocalDate dataNascimento,
    boolean ativo
){
}