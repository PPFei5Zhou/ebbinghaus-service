package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.model.entity.Library;
import com.easy.ebbinghausservice.repository.jpa.LibraryRepository;
import com.easy.ebbinghausservice.repository.jpa.specifications.LibrarySpecs;
import com.easy.ebbinghausservice.service.InterfaceLibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class LibraryService extends BaseService<Library, LibraryRepository> implements InterfaceLibraryService {

    @Override
    public Page<Library> selectEntities(Library model, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<Library> specs = LibrarySpecs.selectEntities(model);
        return jpa.findAll(specs, pageable);
    }
}
