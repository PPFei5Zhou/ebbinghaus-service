package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Knowledge Repository.
 *
 * @author Easy
 */
public interface KnowledgeRepository extends JpaRepository<Knowledge, String>, JpaSpecificationExecutor<Knowledge> {
}
