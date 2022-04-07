package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.core.DatabaseTestConfiguration;
import com.easy.ebbinghausservice.model.entity.Knowledge;
import com.easy.ebbinghausservice.service.KnowledgeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@Import(DatabaseTestConfiguration.class)
@SpringBootTest
class KnowledgeServiceImplTest {
    @Autowired
    private KnowledgeService service;

    @Test
    void service_should_select_entities() {
        Knowledge model = Knowledge.sqlCondition("", "", "", "我", "");
        Page<Knowledge> knowledgeList = service.selectEntities(model, 1, 100);
        assertThat(knowledgeList.getTotalElements(), is(not(0)));
    }
}