package com.grupo3.app.Config.Security;

import com.grupo3.app.Repository.UserRepository;
import com.grupo3.app.Services.UserService;
//import com.grupo3.app.Services.TokenService;
import com.grupo3.app.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }


    // Configuraçao de Autorizaçãp
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers(HttpMethod.POST, "/livro").hasRole("ADM")
                .antMatchers(HttpMethod.DELETE, "/livro/*").hasRole("ADM")
                .antMatchers(HttpMethod.PUT, "/livro/*").hasRole("ADM")
                .antMatchers(HttpMethod.GET, "/aluno").hasRole("ALUNO")
                .antMatchers(HttpMethod.GET, "/aluno/*").permitAll()
                .antMatchers(HttpMethod.GET, "/livro").permitAll()
                //Post Acesso a todos
                .antMatchers(HttpMethod.POST, "/aluno/*").permitAll()
                .antMatchers(HttpMethod.POST, "/bibliotecario").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService,userRepository), UsernamePasswordAuthenticationFilter.class);
       //         .and().formLogin();
    }

    //
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Recursos estaticos (Css, JS , etc ...)
    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
        super.configure(web);
    }


}
