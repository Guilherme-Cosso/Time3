package com.grupo3.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.grupo3.app.Config.Exceptions.ResourceNotFoudException;
import com.grupo3.app.Dto.BibliotecarioDto;
import com.grupo3.app.Dto.BibliotecarioFormDto;
import com.grupo3.app.Services.BibliotecarioServiceImple;




@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BibliotecarioServiceImpleTest {

	final String TEST_NOME = "Ronaldo Assis";
	final String TEST_EMAIL = "ronaldo@email.com";
	final String CPF = "222.222.222-22";
	final String TEST_TELEFONE = "319222222222";

	final Long TEST_VALID_ID = 4L;
	final Long TEST_INVALID_ID = 77L;


	private BibliotecarioDto bibliotecarioDto;
	private BibliotecarioFormDto bibliotecarioFormDto;

	@Autowired
	private BibliotecarioServiceImple service;

	@Autowired
	private ModelMapper mapper;

	void criaBibliotecario() {

		bibliotecarioDto = new BibliotecarioDto();
		bibliotecarioDto.setNome(TEST_NOME);
		bibliotecarioDto.setEmail(TEST_EMAIL);
		bibliotecarioDto.setCpf(CPF);
		bibliotecarioDto.setTelefone(TEST_TELEFONE);

	}

	void criaBibliotecarioAtualizado() {

		bibliotecarioFormDto = new BibliotecarioFormDto();
		bibliotecarioFormDto.setNome("Angelo Augusto");
		bibliotecarioFormDto.setEmail("augusto@gmail.com");
		bibliotecarioFormDto.setCpf("222.222.222-11");
		bibliotecarioFormDto.setTelefone("3199999998");

	}

	@Test
	@DisplayName("Deve lançar erro ao tentar remover bibliotecario com ID inválido")
	void deletePartidoWithInvalidIdTest() {
		assertThrows(ResourceNotFoudException.class, () -> service.deletar(TEST_INVALID_ID));
	}

	@Test
	@DisplayName("Deve retornar uma lista de bibliotecarios")
	void getPartidosTest() {
		List<BibliotecarioDto> bibliotecarios = service.buscarTodos();

		assertFalse(bibliotecarios.isEmpty());
	}

	@Test
	@DisplayName("Deve lançar erro ao tentar atualizar bibliotecario com ID inválido")
	void updatePartidoWithInvalidIdTest() {
		assertThrows(ResourceNotFoudException.class, () -> service.atualizar(TEST_INVALID_ID, bibliotecarioFormDto));
	}

	@Test
	@DisplayName("Deve lançar erro ao procurar por ID inválido")
	void searchPartidoWithInvalidIdTest() {
		assertThrows(ResourceNotFoudException.class, () -> service.buscarId(TEST_INVALID_ID));
	}

}
