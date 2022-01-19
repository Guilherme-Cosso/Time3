package com.grupo3.app.service;

import com.grupo3.app.Config.Exceptions.ResourceNotFoudException;
import com.grupo3.app.Services.AlunoServiceImple;
import com.grupo3.app.Services.BibliotecarioServiceImple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlunoServiceImpleTest {
    final String TEST_NOME = "Alvaro Alves";
    final String TEST_EMAIL = "Alvinho@email.com";
    final String CPF = "222.222.222-22";
    final String TEST_TELEFONE = "319222222222";

    final Long TEST_VALID_ID = 4L;
    final Long TEST_INVALID_ID = 77L;

    @Autowired
    private AlunoServiceImple service;

    @Autowired
    private ModelMapper mapper;


    @Test
    @DisplayName("Deve lançar erro ao tentar remover bibliotecario com ID inválido")
    void deletePartidoWithInvalidIdTest() {
        assertThrows(ResourceNotFoudException.class, () -> service.deletUser(TEST_INVALID_ID));
    }


}
