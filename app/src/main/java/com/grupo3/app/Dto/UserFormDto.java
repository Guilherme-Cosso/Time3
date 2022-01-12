package com.grupo3.app.Dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormDto {

	@NotBlank
    private String name;
	@NotBlank
    private String email;
	@NotBlank
    private String cpf;
	@NotBlank
    private String telefone;
	@NotBlank
    private String matricula;
}
