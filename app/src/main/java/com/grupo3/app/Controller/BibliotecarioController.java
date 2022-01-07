package com.grupo3.app.Controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.grupo3.app.Dto.BibliotecarioDto;
import com.grupo3.app.Dto.BibliotecarioFormDto;
import com.grupo3.app.Dto.MessageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.app.Services.BibliotecarioService;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {

	@Autowired
	private BibliotecarioService service;

	// posta um novo bibliotecario
	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDto cria(@RequestBody @Valid BibliotecarioFormDto bibliotecarioFormDto) {

		return this.service.criar(bibliotecarioFormDto);
	}

	// atualiza bibliotecario
	@PutMapping("/{id}")
	@Transactional
	public MessageResponseDto atualiza(@PathVariable Long id,
			@RequestBody @Valid BibliotecarioFormDto bibliotecarioFormDto) {

		return this.service.atualizar(id, bibliotecarioFormDto);
	}

	// lista todos bibliotecarios cadastrados
	@GetMapping
	public List<BibliotecarioDto> buscaTodos() {
		return service.buscarTodos();
	}

	// lista os bibliotecarios por id
	@GetMapping("/{id}")
	public BibliotecarioDto achaPeloId(@PathVariable Long id) {
		return service.buscarId(id);
	}

	// deleta os bibliotecarios por id
	@DeleteMapping("/{id}")
	public void apagaRegistro(@PathVariable Long id) {
		service.deletar(id);
	}

}
