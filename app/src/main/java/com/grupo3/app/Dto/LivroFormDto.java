package com.grupo3.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroFormDto {
	
	@NotBlank
    private String name;
	@NotBlank
    private String autor;
	@NotBlank
    private String descricao;
	@NotBlank
    private String editora;
	@NotBlank
    private String genero;
	@NotBlank
    private LocalDate datapublicacao;
}
