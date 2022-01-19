package com.grupo3.app.service;


import com.grupo3.app.Config.Exceptions.ResourceNotFoudException;
import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Entity.Livro;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LivroServiceImpleTest {

    private LivroDto livroDto;
    private LivroFormDto livroFormDto;
    final Long ID = 1L;

    @Autowired
    private LivroServiceImple livroServiceImple;

    @Autowired
    private ModelMapper modelMapper;

    public void CriaLivro(){
        livroDto = new LivroDto();
        livroDto.setId(ID);
        livroDto.setName("Livro de historias");
        livroDto.setAutor("Historiadores");
        livroDto.setEditora("HistoBrasil");
        livroDto.setDescricao("Livro conta historias");
        livroDto.setGenero("Estudo");
        livroDto.setDatapublicacao(LocalDate.of(2001,01,01));
    }

    public void AtualizaLivro(){
        livroFormDto = new LivroFormDto();
        livroFormDto.setName("Livro de geografia");
        livroFormDto.setAutor("Geografos");
        livroFormDto.setEditora("GeoBrasil");
        livroFormDto.setDescricao("Livro mostra sobre a geografia");
        livroFormDto.setGenero("Estudo");
        livroFormDto.setDatapublicacao(LocalDate.of(2002, 01, 01));

    }

    @Test
    public void BuscaLivros(){
        List<LivroDto> livros = livroServiceImple.getLivros();
        Assert.assertNotNull(livros);
        Assert.assertEquals(livros, livroServiceImple.getLivros());
    }

    @Test
    public void saveLivro(){
        livroFormDto = new LivroFormDto();
        livroFormDto.setName("Livro de geografia");
        livroFormDto.setAutor("Geografos");
        livroFormDto.setEditora("GeoBrasil");
        livroFormDto.setDescricao("Livro mostra sobre a geografia");
        livroFormDto.setGenero("Estudo");
        livroFormDto.setDatapublicacao(LocalDate.of(2002, 01, 01));
        LivroDto livros = livroServiceImple.save(livroFormDto);
        Assert.assertNotNull(livros);
    }

    @Test
    @Transactional
    public void UpdateLivro(){
        livroFormDto = new LivroFormDto();
        livroFormDto.setName("Livro de geografia");
        livroFormDto.setAutor("Geografos");
        livroFormDto.setEditora("GeoBrasil");
        livroFormDto.setDescricao("Livro mostra sobre a geografia");
        livroFormDto.setGenero("Estudo");
        livroFormDto.setDatapublicacao(LocalDate.of(2002, 01, 01));
        LivroDto livros = livroServiceImple.updateLivro(ID, livroFormDto);
        Assert.assertNotNull(livros);
        Assert.assertEquals(livros, livroServiceImple.updateLivro(ID, livroFormDto));
    }

}
