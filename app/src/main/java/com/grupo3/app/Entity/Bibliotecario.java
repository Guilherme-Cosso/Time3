package com.grupo3.app.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // nao da os construtores
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Bibliotecario extends Usuario {
	private static final long serialVersionUID = 1L;
	

	private String nome;
	private String cpf;
	private String telefone;
	

}
