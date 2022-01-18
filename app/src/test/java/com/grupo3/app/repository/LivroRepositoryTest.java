package com.grupo3.app.repository;

import com.grupo3.app.Entity.Livro;
import com.grupo3.app.Repository.LivroRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LivroRepositoryTest {

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void testFindAllByGenero() {
        Livro livro = new Livro();
        livro.setGenero("magia");

        List<Livro> teste = livroRepository.findAllByGenero(livro.getGenero());
        Assert.assertNotNull(teste);
        Assert.assertEquals(teste, livroRepository.findAllByGenero("magia"));
    }
}
