package com.grupo3.app.Services;

import com.grupo3.app.Entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImple implements TokenService{

    @Value("$`{forum.jwt.expiration}")
    private String expiration;

    @Value("$`{forum.jwt.secret}")
    private String secret;


    @Override
    public String gerarToken(Authentication authentication) {
        Usuario userLogado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiration = new Date(hoje.getTime() + 8450000L);
        return Jwts.builder()
                .setIssuer("Compasso")
                .setSubject(userLogado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact()
                ;
    }

    @Override
    public Boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Long getToken(String token) {
       Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
       return Long.parseLong(claims.getSubject());
    }
}
