package com.grupo3.app.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecarioFormDto {

	@NotBlank
	private String nome;
	@NotBlank  @Email
	private String email;
	@NotBlank @Length(min = 10)
	private String cpf;
	@NotBlank @Length(min = 8) @Length(max = 15)
	private String telefone;
	@NotBlank @Length(min = 8)
	private String senha;
}
