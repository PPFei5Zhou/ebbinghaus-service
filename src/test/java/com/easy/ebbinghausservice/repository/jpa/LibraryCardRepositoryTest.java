package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.core.JpaRepositoryTest;
import com.easy.ebbinghausservice.model.entity.LibraryCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@JpaRepositoryTest
class LibraryCardRepositoryTest {
    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Test
    void repository_should_save_library_card() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        var libraryCard = new LibraryCard("A card title", "A card subtitle", "A card content", "", now, now);
        var savedLibraryCard = libraryCardRepository.saveAndFlush(libraryCard);
        assertThat(savedLibraryCard.getId(), is(notNullValue()));
        assertThat(savedLibraryCard.getCardTitle(), equalTo(libraryCard.getCardTitle()));
    }
}