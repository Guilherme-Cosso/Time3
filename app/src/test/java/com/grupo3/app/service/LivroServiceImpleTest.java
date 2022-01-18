package com.grupo3.app.service;


import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Services.LivroServiceImple;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LivroServiceImpleTest {

    private LivroDto livroDto;
    private LivroFormDto livroFormDto;

    @Autowired
    private LivroServiceImple livroServiceImple;

    @Autowired
    private ModelMapper modelMapper;

    public void CriaLivro(){
        livroDto = new LivroDto();
        livroDto.setName("Livro de historias");
        livroDto.setAutor("Historiadores");
        livroDto.setEditora("HistoBrasil");
        livroDto.setDescricao("Livro conta historias");
        livroDto.setGenero("Estudo");
        livroDto.setDatapublicacao(LocalDate.of(2001,01,01));
    }

    @Test
    public void BuscaLivros(){
        List<LivroDto> livros = livroServiceImple.getLivros();
        Assert.assertNotNull(livros);
        Assert.assertEquals(livros, livroServiceImple.getLivros());
    }
}
