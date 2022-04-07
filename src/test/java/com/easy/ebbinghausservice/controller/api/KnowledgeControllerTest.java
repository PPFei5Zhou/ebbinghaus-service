package com.easy.ebbinghausservice.controller.api;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import com.easy.ebbinghausservice.service.KnowledgeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

@WebMvcTest(value = KnowledgeController.class)
class KnowledgeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KnowledgeService service;

    @Test
    void should_response_ok_when_insert_knowledge() throws Exception {
        given(service.insertEntity(any()))
                .willReturn(any(Knowledge.class));
        byte[] bytes = new ClassPathResource("/request/knowledge/insert_entity.json").getInputStream().readAllBytes();
        mockMvc.perform(post("/api/knowledge")
                .contentType(APPLICATION_JSON)
                .content(bytes))
                .andExpect(status().isOk());
    }

    @Test
    void should_response_ok_when_update_knowledge() throws Exception {
        given(service.updateEntity(any()))
                .willReturn(any(Knowledge.class));
        byte[] bytes = new ClassPathResource("/request/knowledge/update_entity.json").getInputStream().readAllBytes();
        mockMvc.perform(put("/api/knowledge/2219df67-01bf-4b52-81aa-17115b1df1f7")
                        .contentType(APPLICATION_JSON)
                        .content(bytes))
                .andExpect(status().isOk());
    }

    @Test
    void should_response_ok_when_delete_knowledge_by_id() throws Exception {
        doNothing().when(service).removeEntity(any(String.class));
        mockMvc.perform(delete("/api/knowledge/2219df67-01bf-4b52-81aa-17115b1df1f7"))
                .andExpect(status().isOk());
    }

    @Test
    void should_response_ok_when_delete_knowledge() throws Exception {
        doNothing().when(service).removeEntity(any(String[].class));
        byte[] bytes = new ClassPathResource("/request/knowledge/remove_entities.json").getInputStream().readAllBytes();
        mockMvc.perform(delete("/api/knowledge")
                .contentType(APPLICATION_JSON)
                .content(bytes))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_ok_when_select_library() throws Exception {
        int page = 1;
        int size = 10;
        var knowledge = Knowledge.sqlCondition("", "", "", "", "");
        List<Knowledge> knowledgeArrayList = new ArrayList<>();
        knowledgeArrayList.add(knowledge);
        Pageable pageable = PageRequest.of(1, 10);
        PageImpl<Knowledge> result = new PageImpl<>(knowledgeArrayList, pageable, 1);
        given(service.selectEntities(knowledge, page, size)).willReturn(result);

        mockMvc.perform(get("/api/knowledge?page=" + page + "&size=" + size)).andExpect(status().isOk());
    }
}