package com.grupo3.app.Repository;

import com.grupo3.app.Entity.Livro;
import com.grupo3.app.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByUser(Aluno id);

	List<Livro> findAllByGenero(String genero);

}
