package com.easy.ebbinghausservice.repository.jpa.specifications;

import com.easy.ebbinghausservice.model.entity.Library;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Library dynamic select condition.
 *
 * @author Easy
 */
public class LibrarySpecs {
    public static Specification<Library> selectEntities(Library criteria) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Strings.isNotBlank(criteria.getId())) {
                predicates.add(builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getCreateDate() != null) {
                predicates.add(builder.equal(root.get("createDate"), criteria.getCreateDate()));
            }
            if (criteria.getUpdateDate() != null) {
                predicates.add(builder.equal(root.get("updateDate"), criteria.getUpdateDate()));
            }
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
