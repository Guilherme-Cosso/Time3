package com.grupo3.app.Services;

import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroDtoViculado;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Dto.VincularLivroUserDto;
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

	public LivroDtoViculado livroUser(VincularLivroUserDto livroUserDto);

	public List<LivroDto> livrosAssociados(Long id);

	public LivroDto deletLivroUsuario(Long id, Long ids);

	public List<LivroDto> livrosDisponivies();
	

	// tentativa get ordenar
	public List<LivroDto> find(String sort);
	
	public List<LivroDto> buscaGenero (String genero);


}
