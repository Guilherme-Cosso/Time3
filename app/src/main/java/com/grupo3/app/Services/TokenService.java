package com.grupo3.app.Services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
   public String gerarToken(Authentication authentication);

   public Boolean isValid(String token);

   public Long getToken(String token);
}
