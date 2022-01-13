package com.grupo3.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // nao da os construtores
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Bibliotecario extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	

}
