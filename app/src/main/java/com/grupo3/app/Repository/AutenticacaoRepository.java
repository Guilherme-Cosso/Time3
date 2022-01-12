package com.grupo3.app.Repository;

import com.grupo3.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutenticacaoRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);

}
