package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.core.JpaRepositoryTest;
import com.easy.ebbinghausservice.model.entity.Knowledge;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@JpaRepositoryTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KnowledgeRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private KnowledgeRepository repository;

    private final Knowledge knowledge = Knowledge.ofCreated("Test title", "Test subtitle", "Test content", "Test library id");

    @Test
    void repository_should_insert_knowledge() {
        var saved = repository.saveAndFlush(knowledge);
        assertThat(saved.getId(), is(notNullValue()));
        assertSameKnowledge(knowledge, saved);
    }

    @Test
    void repository_should_update_knowledge() {
        var saved = repository.saveAndFlush(knowledge);
        entityManager.detach(saved);
        saved.setTitle("Update title");
        saved.setSubtitle("Update subtitle");
        saved.setContent("Update content");
        saved.setLibraryId("Update library id");
        var updated = repository.saveAndFlush(saved);
        assertThat(updated.getId(), equalTo(saved.getId()));
        assertSameKnowledge(updated, saved);
    }

    @Test
    void repository_should_delete_knowledge() {
        var saved = repository.saveAndFlush(knowledge);
        entityManager.detach(saved);
        repository.deleteById(saved.getId());
        assertThat("", repository.findById(saved.getId()).isEmpty());
    }

    @Test
    void repository_should_find_knowledge() {
        var saved = repository.saveAndFlush(knowledge);
        entityManager.detach(saved);
        Knowledge fund = repository.findById(saved.getId()).orElseThrow(AssertionError::new);
        assertSameKnowledge(knowledge, fund);
    }

    private void assertSameKnowledge(Knowledge expectedKnowledge, Knowledge actualKnowledge) {
        assertThat(expectedKnowledge.getTitle(), equalTo(actualKnowledge.getTitle()));
        assertThat(expectedKnowledge.getSubtitle(), equalTo(actualKnowledge.getSubtitle()));
        assertThat(expectedKnowledge.getContent(), equalTo(actualKnowledge.getContent()));
        assertThat(expectedKnowledge.getLibraryId(), equalTo(actualKnowledge.getLibraryId()));
    }
}