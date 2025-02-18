package com.milioli.musikos.resource;

import com.milioli.musikos.config.MvcConfig;
import com.milioli.musikos.service.MusicianService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MvcConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MusicianResourceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Mock
    private MusicianService service;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void findAll() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/musicians"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        when(service.findById(UUID.fromString("cf980cb7-208c-4d82-860f-fb1bd575f673"))).thenReturn(null);

        mockMvc.perform(get("/musicians/cf980cb7-208c-4d82-860f-fb1bd575f673"))
                .andExpect(status().isOk());
    }

}
