package com.grupo3.app.Repository;


import com.grupo3.app.Entity.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
	public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

		
	}


