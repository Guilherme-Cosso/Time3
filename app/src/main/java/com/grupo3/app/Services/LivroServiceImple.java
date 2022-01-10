package com.grupo3.app.Services;

import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Entity.Livro;
import com.grupo3.app.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImple implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LivroDto save(LivroFormDto body) {
        Livro livro = modelMapper.map(body, Livro.class);
        Livro livroSave = this.livroRepository.save(livro);
        return modelMapper.map(livroSave, LivroDto.class);
    }

    @Override
    public LivroDto getLivro(Long id){
        Livro livro = this.livroRepository.getOne(id);
        return modelMapper.map(livro, LivroDto.class);
    }

    @Override
    public List<LivroDto> getLivros(){
        List<Livro> list = this.livroRepository.findAll();
        return list.stream().map(pa -> modelMapper.map(pa, LivroDto.class)).collect(Collectors.toList());
    }

    @Override
    public LivroDto updateLivro(Long id, LivroFormDto body){
        Livro livro = livroRepository.getOne(id);
        livro.setName(body.getName());
        livro.setAutor(body.getAutor());
        livro.setEditora(body.getEditora());
        livro.setDescricao(body.getDescricao());
        livro.setGenero(body.getGenero());
        livro.setDatapublicacao(body.getDatapublicacao());
        return modelMapper.map(livro, LivroDto.class);
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
