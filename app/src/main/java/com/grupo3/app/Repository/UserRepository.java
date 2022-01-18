package com.grupo3.app.Repository;

import com.grupo3.app.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long>{

    Optional<Usuario> findByEmail(String email);

}
