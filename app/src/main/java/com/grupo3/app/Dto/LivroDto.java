package com.grupo3.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

    private Long id;
    private String name;
    private String autor;
    private String descricao;
    private String editora;
    private String genero;
    private LocalDate datapublicacao;
}
