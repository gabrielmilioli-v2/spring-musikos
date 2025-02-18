package com.milioli.musikos.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milioli.musikos.config.MvcConfig;
import com.milioli.musikos.domain.Musician;
import com.milioli.musikos.enums.Instrument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MvcConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MusicianResourceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/musicians"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/musicians/cf980cb7-208c-4d82-860f-fb1bd575f673"))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {

        final Musician musician = new Musician();
        musician.setName("Gabriel");
        musician.setLastName("Milioli");
        musician.setPassword("senha123");
        musician.setInstrument(Instrument.BAIXO);

        mockMvc.perform(post("/musicians")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(musician)))
                .andExpect(status().isOk());
    }

}
