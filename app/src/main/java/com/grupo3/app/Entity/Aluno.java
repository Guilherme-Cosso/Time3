package com.grupo3.app.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno extends Usuario {
	private static final long serialVersionUID = 1L;


    private String name;
    private String cpf;
    private String telefone;
    private String matricula;
    @OneToMany
    private List<Livro> livros;

    
    // List livros
}
