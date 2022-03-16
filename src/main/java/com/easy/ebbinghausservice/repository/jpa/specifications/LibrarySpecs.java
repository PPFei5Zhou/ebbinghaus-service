package com.easy.ebbinghausservice.repository.jpa.specifications;

import com.easy.ebbinghausservice.model.entity.Library;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Library dynamic select condition.
 *
 * @author Easy
 */
public class LibrarySpecs {
    public static Specification<Library> selectEntities(Library criteria) {
        return (root, query, builder) -> {
            BaseSpecs<Library> baseSpecs = new BaseSpecs<>();
            List<Predicate> predicates = baseSpecs.basePredicates(root, builder, criteria);
            if (Strings.isNotBlank(criteria.getLibraryName())) {
                predicates.add(builder.equal(root.get("libraryName"), criteria.getLibraryName()));
            }
            if (Strings.isNotBlank(criteria.getLibraryParentId())) {
                predicates.add(builder.equal(root.get("libraryParentId"), criteria.getLibraryParentId()));
            }
            if (Strings.isNotBlank(criteria.getLibraryOwnerId())) {
                predicates.add(builder.equal(root.get("libraryOwnerId"), criteria.getLibraryOwnerId()));
            }
            Predicate[] predicateArray = new Predicate[predicates.size()];
            predicates.toArray(predicateArray);
            return query.where(predicateArray).getRestriction();
        };
    }
}
