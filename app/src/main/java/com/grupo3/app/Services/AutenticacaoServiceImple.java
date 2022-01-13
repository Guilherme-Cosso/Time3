package com.grupo3.app.Services;

import com.grupo3.app.Dto.LoginForm;
import com.grupo3.app.Entity.Aluno;
import com.grupo3.app.Repository.AutenticacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoServiceImple implements UserDetailsService /*, AutenticacaoService*/ {

    @Autowired
    AutenticacaoRepository autenticacaoRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Optional<Aluno> user =  autenticacaoRepository.findByEmail(email);
      if(user.isPresent()){
          return user.get();
      }
        throw  new UsernameNotFoundException("Dados Invalidos");
    }


//    @Override
//    public void verificarUser(LoginForm body) {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(body.getEmail(),body.getSenha());
//       try {
//           Authentication authentication = authenticationManager.authenticate(authenticationToken);
//           String token = tokenService.gerarToken(authentication);
//           System.out.println(token);
//       }catch (AuthenticationException e){
//
//       }
//    }
}
