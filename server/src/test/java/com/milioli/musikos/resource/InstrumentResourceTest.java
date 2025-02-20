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
public class InstrumentResourceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/instruments"))
                .andExpect(status().isOk());
    }

}
