package com.grupo3.app.Dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.time.LocalDate;
@Data
public class LivroDtoViculado {
    private Long id;
    private String name;
    private String autor;
    private String descricao;
    private String editora;
    private String genero;
    private LocalDate datapublicacao;
    @JsonManagedReference
    private UserDto user;
}
