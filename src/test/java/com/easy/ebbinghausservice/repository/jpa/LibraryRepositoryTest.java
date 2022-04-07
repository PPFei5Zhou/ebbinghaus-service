package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.core.JpaRepositoryTest;
import com.easy.ebbinghausservice.model.entity.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

@JpaRepositoryTest
class LibraryRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LibraryRepository repository;

    private final Library library =
            Library.ofCreate("test library name", "test library description", "test library parent id", "test library owner id");

    @Test
    void repository_should_save_library() {
        Library savedLibrary = repository.saveAndFlush(library);
        assertThat(savedLibrary.getId(), is(notNullValue()));
        assertSameLibrary(library, savedLibrary);
    }

    @Test
    void repository_should_update_library() {
        Library saved = repository.saveAndFlush(library);
        entityManager.detach(saved);
        Library update = repository.findById(saved.getId()).orElseThrow(AssertionError::new);
        update.setLibraryName("update name");
        update.setLibraryDescription("update description");
        update.setLibraryParentId("update parent id");
        update.setLibraryOwnerId("update owner id");
        Library updated = repository.saveAndFlush(update);
        assertSameLibrary(update, updated);
    }

    @Test
    void repository_should_delete_library() {
        Library saved = repository.saveAndFlush(library);
        entityManager.detach(saved);
        repository.deleteById(saved.getId());
        assertThat(repository.findById(saved.getId()).isEmpty(), is(true));
    }

    void assertSameLibrary(Library expected, Library actual) {
        assertThat(expected.getId(), equalTo(actual.getId()));
        assertThat(expected.getLibraryName(), equalTo(actual.getLibraryName()));
        assertThat(expected.getLibraryDescription(), equalTo(actual.getLibraryDescription()));
        assertThat(expected.getLibraryParentId(), equalTo(actual.getLibraryParentId()));
        assertThat(expected.getLibraryOwnerId(), equalTo(actual.getLibraryOwnerId()));
    }
}