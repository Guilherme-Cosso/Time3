package com.compass.biblioteca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.biblioteca.entity.Bibliotecario;

	@Repository
	public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

		
	}


