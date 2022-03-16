package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.model.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Library card jpa repository.
 *
 * @author Easy
 */
public interface LibraryCardRepository extends JpaRepository<LibraryCard, String> {
}
