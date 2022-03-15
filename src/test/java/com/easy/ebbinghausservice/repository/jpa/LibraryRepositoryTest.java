package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.core.JpaRepositoryTest;
import com.easy.ebbinghausservice.model.entity.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

@JpaRepositoryTest
class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository repository;

    @Test
    void repository_should_save_library() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Library library = new Library("test library name", "", "", now, now);
        Library savedLibrary = repository.saveAndFlush(library);
        assertThat(savedLibrary.getId(), is(notNullValue()));
        assertThat(savedLibrary.getLibraryName(), equalTo(library.getLibraryName()));
    }
}