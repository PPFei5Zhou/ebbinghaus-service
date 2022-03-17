package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.model.entity.LibraryCard;
import com.easy.ebbinghausservice.repository.jpa.LibraryCardRepository;
import com.easy.ebbinghausservice.repository.jpa.specifications.LibraryCardSpecs;
import com.easy.ebbinghausservice.service.LibraryCardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Library Card Service an implement.
 *
 * @author Easy
 */
@Service
public class LibraryCardServiceImpl extends AbstractService<LibraryCard, LibraryCardRepository> implements LibraryCardService {
    @Override
    public Page<LibraryCard> selectEntities(LibraryCard model, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<LibraryCard> specs = LibraryCardSpecs.selectEntities(model);
        return jpa.findAll(specs, pageable);
    }
}
