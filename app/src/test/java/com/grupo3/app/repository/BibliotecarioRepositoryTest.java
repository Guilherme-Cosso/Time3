package com.grupo3.app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.grupo3.app.Entity.Bibliotecario;
import com.grupo3.app.Repository.BibliotecarioRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BibliotecarioRepositoryTest {

    final String emailInvalido ="invalido@email.com";

    private Bibliotecario bibliotecario;

    @Autowired
    private BibliotecarioRepository repository;

    @Autowired
    private TestEntityManager em;

    @BeforeEach
    public void criaBibliotecario() {
        bibliotecario = new Bibliotecario();
        bibliotecario.setNome("Arnaldo Antunes");
        bibliotecario.setCpf("333.333.333-33");
        bibliotecario.setEmail("arnaldo@email.com");
        bibliotecario.setTelefone("31985858585");
        
        em.persist(bibliotecario);
    }

    @Test
    @DisplayName("Deve carregar uma lista de bibliotecario ao buscar por um email válido")
    void buscaPorEmailBibliotecarioTeste() {
        Optional<Bibliotecario> bibliotecarios = repository.findByEmail("arnaldo@email.com");

        assertFalse(bibliotecarios.isEmpty());
        assertEquals(bibliotecarios.get().getNome(), bibliotecario.getNome());
        assertEquals(bibliotecarios.get().getCpf() , bibliotecario.getCpf());
        assertEquals(bibliotecarios.get().getEmail(), bibliotecario.getEmail());
        assertEquals(bibliotecarios.get().getTelefone(), bibliotecario.getTelefone());
    }

    @Test
    @DisplayName("Deve carregar uma lista vazia ao buscar por uma ideologia válida, mas ausente")
    void buscaPorEmailInvalido() {
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setEmail(emailInvalido);
        

        Optional<Bibliotecario> teste = repository.findByEmail(emailInvalido);

        assertTrue(teste.isEmpty());
    }
}