package com.grupo3.app.Services;

import java.util.List;

import com.grupo3.app.Dto.BibliotecarioDto;
import com.grupo3.app.Dto.BibliotecarioFormDto;
import com.grupo3.app.Dto.MessageResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BibliotecarioService {

	MessageResponseDto criar(BibliotecarioFormDto bibliotecarioFormDto);
	
	MessageResponseDto atualizar(Long id, BibliotecarioFormDto bibliotecarioFormDto);

	BibliotecarioDto buscarId(Long id);

	List<BibliotecarioDto> buscarTodos();
	
	public void deletar(Long id);

}
