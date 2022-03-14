package com.easy.ebbinghaus_service;

import com.easy.ebbinghaus_service.core.DatabaseTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(DatabaseTestConfiguration.class)
public class SmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_ok_when_request_endpoint_of_health() throws Exception {
        mockMvc
                .perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
