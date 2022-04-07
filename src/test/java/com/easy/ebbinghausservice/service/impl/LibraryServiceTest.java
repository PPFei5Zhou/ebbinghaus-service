package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.core.DatabaseTestConfiguration;
import com.easy.ebbinghausservice.model.entity.Library;
import com.easy.ebbinghausservice.service.LibraryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@Import(DatabaseTestConfiguration.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryServiceTest {

    @Resource
    private LibraryService libraryService;

    private final String id = "026a0e3c-dc45-444e-9ffd-424cb6fe48a5";

    private final String[] ids = {
        "fd1b67d6-199d-4cdb-ace7-202a65f29a1d",
        "f45bfc1b-3c8e-4ba1-92ea-b4fa1d8666ab",
        "ee3ae32e-a43e-460f-813d-e66e95d2db6f",
        "e4f70225-457a-42e3-af87-087a06eff544",
        "e3a77219-2db6-4856-82a1-68feef339d9d"
    };

    @Order(1)
    @Test
    void service_should_insert_entity() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Library library = new Library("算查表子", "", "", "8eB7bF4C-4f1e-aBeD-cAd1-AEbA138a1Cf4", now, now);
        Library inserted = libraryService.insertEntity(library);
        assertThat(inserted.getId(), is(notNullValue()));
        assertThat(inserted.getLibraryName(), equalTo(library.getLibraryName()));
        assertThat(true, is(true));
    }

    @Order(2)
    @Test
    void service_should_update_entity() {
        Library saved = new Library(id, "识出你交务", null, null);
        Library updated = libraryService.updateEntity(saved);
        assertThat(updated.getLibraryName(), is(saved.getLibraryName()));
    }

    @Order(3)
    @Test
    void service_should_select_entity() {
        Library library = libraryService.selectEntityById(id);
        assertNotNull(library);
    }

    @Order(4)
    @Test
    void service_should_select_entities() {
        Library library = new Library("", "", "", "c53bA5B3-f286-2eBf-8A7E-2B7E7Aff1b2A");
        Page<Library> libraries = libraryService.selectEntities(library, 1, Integer.MAX_VALUE);
        assertThat(libraries.getTotalElements(), is(notNullValue()));
    }

    @Order(5)
    @Test
    void service_should_delete_entity() {
        libraryService.removeEntity(id);
        assertThat("No Error", true);
    }

    @Order(6)
    @Test
    void service_should_delete_entities() {
        libraryService.removeEntity(ids);
        assertThat("No Error", true);
    }
}