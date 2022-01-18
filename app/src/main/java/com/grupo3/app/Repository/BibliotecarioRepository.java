package com.grupo3.app.Repository;


import com.grupo3.app.Entity.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
	public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

	Optional<Bibliotecario> findByEmail(String email);
}


