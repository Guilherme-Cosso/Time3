package com.grupo3.app.Repository;

import com.grupo3.app.Entity.Livro;
import com.grupo3.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByUser(User id);

	List<Livro> findAllByGenero(String genero);

}
