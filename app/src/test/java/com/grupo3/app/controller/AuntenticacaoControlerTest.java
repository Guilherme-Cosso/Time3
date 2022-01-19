package com.grupo3.app.controller;

import com.grupo3.app.Services.TokenService;
import com.grupo3.app.Services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuntenticacaoControlerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void  deveriadevolver200() throws Exception {
        URI uri  = new URI("/auth");
        String json = "  {\"email\":\"arnoR@gmail.com\",\n\"senha\":\"123456\"}";

        String adminToken = "1";
        mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .header("Authorization", "bearer" + adminToken)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers
                .status()
                .is(200));

    }
    @Test
    public void  deveriadevolver400() throws Exception {
        URI uri  = new URI("/auth");
        String json = "  {\"email\":\"arnoRe@gmail.com\",\n\"senha\":\"123456\"}";
        String adminToken = "1";
        mvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .header("Authorization", "bearer" + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));

    }


}
