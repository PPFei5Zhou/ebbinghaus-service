package com.easy.ebbinghausservice.repository.jpa;

import com.easy.ebbinghausservice.model.entity.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Basic repository.
 *
 * @author Easy
 */
public interface BaseRepository<T extends Base> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
    /**
     * find all.
     * fix the problem of n+1
     *
     * @param spec Specification in the sense of Domain Driven Design.
     * @param pageable Abstract interface for pagination information.
     * @return A page is a sublist of a list of objects. It allows gain information about the position of it in the containing entire list.
     */
    @Override
    @EntityGraph(value = "Library.Graph", type = EntityGraph.EntityGraphType.FETCH)
    Page<T> findAll(Specification<T> spec, Pageable pageable);
}
