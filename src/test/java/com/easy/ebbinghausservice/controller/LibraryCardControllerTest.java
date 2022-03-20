package com.easy.ebbinghausservice.controller;

import com.easy.ebbinghausservice.controller.api.LibraryCardController;
import com.easy.ebbinghausservice.model.entity.LibraryCard;
import com.easy.ebbinghausservice.service.LibraryCardService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = LibraryCardController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryCardService service;

    @Order(1)
    @Test
    void request_should_return_ok_when_request_insert_entity() throws Exception {
        given(service.insertEntity(any(LibraryCard.class))).willReturn(any(LibraryCard.class));
        byte[] bytes = new ClassPathResource("/request/libraryCard/insert_entity.json").getInputStream().readAllBytes();
        mockMvc
                .perform(post("/api/libraryCard")
                        .contentType(APPLICATION_JSON)
                        .content(bytes))
                .andExpect(status().isOk());
    }

    @Order(2)
    @Test
    void request_should_return_ok_when_request_update_entity() throws Exception {
        given(service.updateEntity(any(LibraryCard.class))).willReturn(any(LibraryCard.class));
        byte[] bytes = new ClassPathResource("/request/libraryCard/update_entity.json").getInputStream().readAllBytes();
        mockMvc
                .perform(put("/api/libraryCard/c1fE377B-6F39-fe26-CeeD-8FBCc0D28CC7")
                        .contentType(APPLICATION_JSON)
                        .content(bytes))
                .andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void request_should_return_ok_when_request_delete_entity() throws Exception {
        doNothing().when(service).removeEntity(any(String.class));
        mockMvc
                .perform(delete("/api/libraryCard/dD8BBBd3-43Cb-CAD2-Ff4F-ce5d9aA363E3"))
                .andExpect(status().isOk());
    }

    @Order(4)
    @Test
    void request_should_return_ok_when_request_delete_entities() throws Exception {
        doNothing().when(service).removeEntity(any(String[].class));
        byte[] bytes = new ClassPathResource("/request/libraryCard/remove_entities.json").getInputStream().readAllBytes();
        mockMvc
                .perform(delete("/api/libraryCard")
                        .contentType(APPLICATION_JSON)
                        .content(bytes))
                .andExpect(status().isOk());
    }

    @Order(5)
    @Test
    void request_should_return_ok_when_request_select_entity() throws Exception {
        given(service.selectEntityById(any(String.class))).willReturn(any(LibraryCard.class));
        mockMvc
                .perform(get("/api/libraryCard/B2e054DD-73F3-fC2D-A7df-CAEB39d3ecf0"))
                .andExpect(status().isOk());
    }

    @Order(6)
    @Test
    void request_should_return_ok_when_request_select_entities() throws Exception {
        int page = 1;
        int size = 10;
        LibraryCard libraryCard = new LibraryCard();
        List<LibraryCard> list = new ArrayList<>();
        PageImpl<LibraryCard> result = new PageImpl<>(list);
        byte[] bytes = new ClassPathResource("/request/libraryCard/select_entities.json").getInputStream().readAllBytes();
        given(service.selectEntities(libraryCard, page, size)).willReturn(result);
        mockMvc
                .perform(get("/api/libraryCard?page=" + page + "&size=" + size)
                        .contentType(APPLICATION_JSON)
                        .content(bytes))
                .andExpect(status().isOk());

    }
}