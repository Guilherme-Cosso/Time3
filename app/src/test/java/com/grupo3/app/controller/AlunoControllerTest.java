package com.grupo3.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AlunoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void  deveriaDevolvernoForbiden() throws Exception {
        URI uri  = new URI("/aluno");
        String adminToken = "1";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .header("Authorization", "bearer" + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().isForbidden());

    }

    @Test
    public void  deveriaDevolverno200okGet() throws Exception {
        URI uri  = new URI("/aluno");
        String adminToken = " eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDb21wYXNzbyIsInN1YiI6IjUiLCJpYXQiOjE2NDI1NDc4MzQsImV4cCI6MTY0MjU1NjI4NH0.5bKbFoyO6k2op9yRXta_afAJyvqqlAyRjjhbtJhhZgE";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .header("Authorization", "Bearer" + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

    }

    @Test
    public void  deveriaDevolverno200okGetId() throws Exception {
        URI uri  = new URI("/aluno");
        String adminToken = " eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDb21wYXNzbyIsInN1YiI6IjUiLCJpYXQiOjE2NDI1NDc4MzQsImV4cCI6MTY0MjU1NjI4NH0.5bKbFoyO6k2op9yRXta_afAJyvqqlAyRjjhbtJhhZgE";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .pathInfo("/1")
                        .header("Authorization", "Bearer" + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    public void  deveriaDevolverno400okGetId() throws Exception {
        URI uri  = new URI("/aluno");
        String adminToken = " eyJhbGciOiJIUzI1NiJ9.pc3MiOiJDb21wYXNzbyIsInN1YiI6IjUiLCJpYXQiOjE2NDI1NDc4MzQsImV4cCI6MTY0MjU1NjI4NH0.5bKbFoyO6k2op9yRXta_afAJyvqqlAyRjjhbtJhhZgE";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .pathInfo("/1")
                        .header("Authorization", "Bearer" + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().isForbidden());
    }




}
