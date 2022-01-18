package com.grupo3.app.Controller;


import com.grupo3.app.Dto.LoginForm;
import com.grupo3.app.Dto.TokenDto;
import com.grupo3.app.Services.UserService;
import com.grupo3.app.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    
    @Autowired
    UserService autenticacaoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> User(@RequestBody @Valid LoginForm body) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(body.getEmail(),body.getSenha());
       try {
           Authentication authentication = authenticationManager.authenticate(authenticationToken);
           String token = tokenService.gerarToken(authentication);
           return ResponseEntity.ok(new TokenDto(token, "Bearer"));
       }catch (AuthenticationException e){
           System.out.println(e);
            return  ResponseEntity.badRequest().build();
       }
    }
}
