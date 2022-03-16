package com.easy.ebbinghausservice.repository.jpa.specifications;

import com.easy.ebbinghausservice.model.entity.LibraryCard;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Library card dynamic select condition.
 *
 * @author Easy
 */
public class LibraryCardSpecs {
    public static Specification<LibraryCard> selectEntities(LibraryCard criteria) {
        return (root, query, builder) -> {
            BaseSpecs<LibraryCard> baseSpecs = new BaseSpecs<>();
            List<Predicate> predicates = baseSpecs.basePredicates(root, builder, criteria);
            if (Strings.isNotBlank(criteria.getCardTitle())) {
                predicates.add(builder.equal(root.get("cardTitle"), criteria.getCardTitle()));
            }
            if (Strings.isNotBlank(criteria.getCardSubtitle())) {
                predicates.add(builder.equal(root.get("cardSubtitle"), criteria.getCardSubtitle()));
            }
            if (Strings.isNotBlank(criteria.getCardContent())) {
                predicates.add(builder.equal(root.get("cardContent"), criteria.getCardContent()));
            }
            if (Strings.isNotBlank(criteria.getLibraryId())) {
                predicates.add(builder.equal(root.get("libraryId"), criteria.getLibraryId()));
            }
            Predicate[] predicateArray = new Predicate[predicates.size()];
            predicates.toArray(predicateArray);
            return query.where(predicateArray).getRestriction();
        };
    }
}
