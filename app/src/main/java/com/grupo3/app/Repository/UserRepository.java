package com.grupo3.app.Repository;

import com.grupo3.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   // User findByID(long id);
    List<User> findByEmail(String email);


}
