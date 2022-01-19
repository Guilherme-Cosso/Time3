package com.grupo3.app.repository;

import com.grupo3.app.Entity.Aluno;
import com.grupo3.app.Repository.AlunoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testFindEmailCorreto() {
        Aluno aluno = new Aluno();
        aluno.setNome("g@gmail.com");
        List<Aluno> teste = alunoRepository.findByEmail("g@gmail.com");
        Assert.assertNotNull(teste);
        Assert.assertEquals(teste, alunoRepository.findByEmail("g@gmail.com"));
    }

}
