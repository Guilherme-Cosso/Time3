package com.grupo3.app.Repository;

import com.grupo3.app.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

   // User findByID(long id);
    List<Aluno> findByEmail(String email);


}
