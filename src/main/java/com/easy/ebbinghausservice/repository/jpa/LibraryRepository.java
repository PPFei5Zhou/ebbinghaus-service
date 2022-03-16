package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.model.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Library jpa repository.
 *
 * @author Easy
 */
public interface LibraryRepository extends JpaRepository<Library, String>, JpaSpecificationExecutor<Library> {
}
