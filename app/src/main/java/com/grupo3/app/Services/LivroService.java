package com.grupo3.app.Services;

import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroFormDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface LivroService {

    public LivroDto save(@RequestBody LivroFormDto livroFormDto);
    public LivroDto getLivro(Long id);

    public List<LivroDto> getLivros();
    public LivroDto updateLivro(Long id, @RequestBody LivroFormDto livroFormDto);
    public void deleteLivro(Long id);

}