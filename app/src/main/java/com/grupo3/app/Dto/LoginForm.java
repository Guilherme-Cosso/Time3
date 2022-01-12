package com.grupo3.app.Dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginForm {
    
    String email;
    String senha;

}
