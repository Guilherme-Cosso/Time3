package com.grupo3.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormDto {

    private String name;
    private String email;
    private String cpf;
    private String telefone;
    private String matricula;
}
