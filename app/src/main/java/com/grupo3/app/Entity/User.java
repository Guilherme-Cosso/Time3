package com.grupo3.app.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty
    private String telefone;
    @NotNull @NotEmpty
    private String matricula;
    @OneToMany
    private List<Livro> livros;
    // List livros
}
