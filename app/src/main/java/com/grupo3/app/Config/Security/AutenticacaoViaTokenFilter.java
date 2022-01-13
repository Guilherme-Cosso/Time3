package com.grupo3.app.Config.Security;

import com.grupo3.app.Entity.Aluno;
import com.grupo3.app.Repository.AlunoRepository;
import com.grupo3.app.Services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private AlunoRepository userRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, AlunoRepository userRepository){
        this.tokenService =tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        System.out.println(token);
        Boolean valid = tokenService.isValid(token);
        System.out.println(valid);
        if (valid){
            autenticarUser(token);
        }
        filterChain.doFilter(request,response);
    }

    private void autenticarUser(String token) {
        Optional<Aluno> user = userRepository.findById(tokenService.getToken(token));
        UsernamePasswordAuthenticationToken authentication =  new UsernamePasswordAuthenticationToken(user.get(),null, user.get().getPerfis());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (!token.startsWith("Bearer")  ||  token.isBlank()){
            return null;
        }
        return token.substring(7,token.length());
    }
}
