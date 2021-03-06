package com.grupo3.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String matricula;
    private String senha;
}
