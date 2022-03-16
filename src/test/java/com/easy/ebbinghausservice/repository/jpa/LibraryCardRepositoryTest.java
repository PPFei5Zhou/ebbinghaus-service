package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.core.JpaRepositoryTest;
import com.easy.ebbinghausservice.model.entity.LibraryCard;
import com.easy.ebbinghausservice.repository.jpa.specifications.LibraryCardSpecs;
import com.easy.ebbinghausservice.utils.JpaUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

@JpaRepositoryTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryCardRepositoryTest {
    @Autowired
    private LibraryCardRepository repository;

    @Order(1)
    @Test
    void repository_should_save_library_card() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        var libraryCard = new LibraryCard("号领打际包实", "群铁劳温",
                "世值门没比重起华界水东问高。原北它四万部火次不类已长立习。系么真上太工严器类提而高示时接状。省便回证文称理速单南产布。",
                "cB94d7f0-36FE-c7cb-4Cd8-636B8094271B", now, now);
        var savedLibraryCard = repository.saveAndFlush(libraryCard);
        assertThat(savedLibraryCard.getId(), is(notNullValue()));
        assertThat(savedLibraryCard.getCardTitle(), equalTo(libraryCard.getCardTitle()));
    }

    @Order(2)
    @Test
    void repository_should_update_library_card() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        LibraryCard updated = new LibraryCard("56D1aCf7-A5dD-ed6c-659E-ffD3CF16F98f", null, null, null, null, null, now);
        Optional<LibraryCard> optional = repository.findById(updated.getId());
        if (optional.isPresent()) {
            JpaUtil.copyNotNullProperties(updated, optional.get());
            LibraryCard saved = repository.saveAndFlush(optional.get());
            assertThat(saved.getCardTitle(), is(notNullValue()));
            assertThat(saved.getCardSubtitle(), is(notNullValue()));
            assertThat(saved.getLibraryId(), is(notNullValue()));
            assertThat(saved.getCreateDate(), is(notNullValue()));
            assertThat(saved.getUpdateDate(), is(now));
        }
    }

    @Order(3)
    @Test
    void repository_should_delete_library_card() {
        String id = "2abd714F-f5aF-e794-8806-954079f601E0";
        repository.deleteById(id);
        assertThat("No Error", true);
    }

    @Order(4)
    @Test
    void repository_should_delete_library_cards() {
        String[] ids = {
            "7E5E9372-95fB-183B-8eCd-A19032bc9F12",
            "BdA05aAC-CDDC-8D4B-137e-c338fA0d5edE",
            "cd3bCD3d-0CBD-dBFc-22A7-e1469E0FEAFE"
        };
        repository.deleteAllByIdInBatch(Arrays.asList(ids));
        assertThat("No Error", true);
    }

    @Order(5)
    @Test
    void repository_should_select_library_card_by_id() {
        Optional<LibraryCard> optional = repository.findById("dDaFE5D5-EDec-7d2A-c0d2-e20D68d186ca");
        assertThat("No fund", optional.isPresent());
    }

    @Order(6)
    @Test
    void repository_should_select_library_cards() {
        Timestamp createDate = Timestamp.valueOf("1970-01-06 10:40:15");
        Timestamp updateDate = Timestamp.valueOf("2004-03-13 15:05:35");
        LibraryCard card = new LibraryCard(
                "49dcEA57-c757-bD4c-7319-DFdE1fe8d7fF",
                "油认战为连",
                "目成山今",
                "",
                "daac6c91-0e3f-405b-9c5f-3b28bf1a7160",
                createDate,
                updateDate);
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        Specification<LibraryCard> specs = LibraryCardSpecs.selectEntities(card);
        Page<LibraryCard> result = repository.findAll(specs, pageable);
        assertThat(result.getTotalElements(), is(not(0)));
    }
}