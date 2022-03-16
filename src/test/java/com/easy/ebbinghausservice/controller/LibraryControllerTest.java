package com.easy.ebbinghausservice.controller;

import com.easy.ebbinghausservice.model.request.LibraryRequestBody;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryController libraryController;

    @Order(1)
    @Test
    void should_return_ok_when_insert_library() throws Exception {
        given(libraryController.insertEntity(any())).willReturn(ResponseEntity.ok().build());
        byte[] requestBody = new ClassPathResource("/request/library/insert_entity.json").getInputStream().readAllBytes();
        mockMvc.perform(post("/library")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Order(2)
    @Test
    void should_return_ok_when_update_library() throws Exception {
        given(libraryController.insertEntity(any())).willReturn(ResponseEntity.ok().build());
        byte[] requestBody = new ClassPathResource("/request/library/update_entity.json").getInputStream().readAllBytes();
        mockMvc.perform(put("/library/2219df67-01bf-4b52-81aa-17115b1df1f7")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void should_return_ok_when_delete_one_library() throws Exception {
        given(libraryController.removeEntity(any())).willReturn(ResponseEntity.ok().build());
        mockMvc.perform(delete("/library/D965F9e6-76F5-CAc8-83BD-4F429E4CC91c")).andExpect(status().isOk());
    }

    @Order(4)
    @Test
    void should_return_ok_when_delete_library() throws Exception {
        given(libraryController.removeEntities(any())).willReturn(ResponseEntity.ok().build());
        byte[] requestBody = new ClassPathResource("/request/library/remove_entities.json").getInputStream().readAllBytes();
        mockMvc.perform(delete("/library")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Order(5)
    @Test
    void should_return_ok_when_select_one_library() throws Exception {
        given(libraryController.selectEntity(any())).willReturn(ResponseEntity.ok().build());
        mockMvc.perform(get("/library/57b5622c-81c3-49a2-935a-1b73c200da30")).andExpect(status().isOk());
    }

    @Order(6)
    @Test
    void should_return_ok_when_select_library() throws Exception {
        int page = 1;
        int size = 10;
        var library = new LibraryRequestBody();
        given(libraryController.selectEntities(library, page, size)).willReturn(ResponseEntity.ok().build());
        byte[] requestBody = new ClassPathResource("/request/library/select_entities.json").getInputStream().readAllBytes();
        mockMvc.perform(get("/library?page=" + page + "&size=" + size)
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }
}