package com.milioli.musikos.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milioli.musikos.config.GlobalTestConfig;
import com.milioli.musikos.domain.Musician;
import com.milioli.musikos.enums.Instrument;
import com.milioli.musikos.record.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@GlobalTestConfig
public class MusicianResourceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/musicians"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/musicians/cf980cb7-208c-4d82-860f-fb1bd575f673"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {

        final Musician musician = new Musician();
        musician.setFirstName("Gabriel");
        musician.setLastName("Milioli");
        musician.setPassword("senha123");
        musician.setEmail("gabriel@milioli.com");
        musician.setInstrument(Instrument.BAIXO);
        musician.setAddress(new Address("88020340", "", "", "", ""));

        final String responseAsString = mockMvc.perform(post("/api/musicians")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(musician)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        final Musician musicianCreated = objectMapper.readValue(responseAsString, Musician.class);

        Assertions.assertThat(musicianCreated).isNotNull();
        Assertions.assertThat(musicianCreated.getId()).isNotNull();
        Assertions.assertThat(musicianCreated.getEncodedPassword()).isNotNull();

    }

}
