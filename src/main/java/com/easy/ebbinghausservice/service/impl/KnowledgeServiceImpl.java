package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import com.easy.ebbinghausservice.repository.jpa.KnowledgeRepository;
import com.easy.ebbinghausservice.repository.jpa.specifications.KnowledgeSpecs;
import com.easy.ebbinghausservice.service.KnowledgeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Knowledge service an implement.
 *
 * @author Easy
 */
@Service
public class KnowledgeServiceImpl extends AbstractService<Knowledge, KnowledgeRepository> implements KnowledgeService {
    @Override
    public Page<Knowledge> selectEntities(Knowledge model, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<Knowledge> specification = KnowledgeSpecs.specification(model);
        return jpa.findAll(specification, pageable);
    }
}
