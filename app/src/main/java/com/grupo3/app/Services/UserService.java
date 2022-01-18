package com.grupo3.app.Services;

import com.grupo3.app.Entity.Usuario;
import com.grupo3.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService  {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Optional<Usuario> user =  userRepository.findByEmail(email);
      System.out.println(user.get());
      if(user.isPresent()){

          return user.get();
      }
        throw  new UsernameNotFoundException("Dados Invalidos");
    }


}
