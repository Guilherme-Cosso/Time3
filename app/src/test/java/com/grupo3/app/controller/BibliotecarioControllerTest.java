package com.grupo3.app.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test-emptydb")
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BibliotecarioControllerTest {

	static String BIBLIOTECARIO_URI = "/bibliotecarios";

	@Autowired
	private MockMvc mvc;

	/* Teste POST */

	@Test
	@DisplayName("Deve criar um bibliotecario com sucesso")
	void saveAssociadoTest() throws Exception {
		String json = "{" + "\"nome\":\"b\"," + "\"email\":\"geraldo@gmail.com\"," + "\"cpf\":\"111.222.333-44\","
				+ "\"telefone\":\"31999999999\"" + "}";

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(BIBLIOTECARIO_URI)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		mvc.perform(request).andExpect(status().isCreated()).andExpect(jsonPath("nome").value("b"))
				.andExpect(jsonPath("email").value("geraldo@gmail.com"))
				.andExpect(jsonPath("cpf").value("111.222.333-44"))
				.andExpect(jsonPath("telefone").value("31999999999"));
	}

	@Test
	@DisplayName("Deve lançar erro de validação ao criar quando um ou mais campos estiverem vazios")
	void saveAssociadoWithEmptyFieldsTest() throws Exception {
		String json = "{" + "\"nome\":\"\"," + "\"email\":\"\"," + "\"cpf\":\"\"," + "\"telefone\":\"\"" + "}";

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(BIBLIOTECARIO_URI)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		mvc.perform(request).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.fieldErrors[0].field").value("nome"))
				.andExpect(jsonPath("$.fieldErrors[1].field").value("email"))
				.andExpect(jsonPath("$.fieldErrors[2].field").value("cpf"))
				.andExpect(jsonPath("$.fieldErrors[3].field").value("telefone"));
	}

}
