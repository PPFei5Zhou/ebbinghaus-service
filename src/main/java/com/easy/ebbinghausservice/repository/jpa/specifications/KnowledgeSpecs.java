package com.easy.ebbinghausservice.repository.jpa.specifications;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Knowledge dynamic select condition.
 *
 * @author Easy
 */
public class KnowledgeSpecs {
    public static Specification<Knowledge> specification(Knowledge criteria) {
        return (root, query, builder) -> {
            BaseSpecs<Knowledge> baseSpecs = new BaseSpecs<>();
            List<Predicate> predicates = baseSpecs.basePredicates(root, builder, criteria);
            if (StringUtils.hasText(criteria.getTitle())) {
                predicates.add(builder.like(root.get("title"), "%" + criteria.getTitle() + "%"));
            }
            if (StringUtils.hasText(criteria.getSubtitle())) {
                predicates.add(builder.like(root.get("subtitle"), "%" + criteria.getSubtitle() + "%"));
            }
            if (StringUtils.hasText(criteria.getContent())) {
                predicates.add(builder.like(root.get("content"), "%" + criteria.getContent() + "%"));
            }
            if (StringUtils.hasText(criteria.getLibraryId())) {
                predicates.add(builder.equal(root.get("libraryId"), criteria.getLibraryId()));
            }
            Predicate[] predicateArray = new Predicate[predicates.size()];
            predicates.toArray(predicateArray);
            return query.where(predicateArray).getRestriction();
        };
    }
}
