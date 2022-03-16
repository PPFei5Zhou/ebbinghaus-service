package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.model.entity.Library;
import com.easy.ebbinghausservice.repository.jpa.LibraryRepository;
import com.easy.ebbinghausservice.repository.jpa.specifications.LibrarySpecs;
import com.easy.ebbinghausservice.service.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Library service an implement.
 *
 * @author Easy
 */
@Service
public class LibraryServiceImpl extends AbstractService<Library, LibraryRepository> implements LibraryService {

    @Override
    public Page<Library> selectEntities(Library model, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<Library> specs = LibrarySpecs.selectEntities(model);
        return jpa.findAll(specs, pageable);
    }
}
