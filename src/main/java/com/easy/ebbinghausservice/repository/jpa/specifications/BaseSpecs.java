package com.easy.ebbinghausservice.repository.jpa.specifications;

import com.easy.ebbinghausservice.model.entity.Base;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic dynamic select condition.
 *
 * @author Easy
 */
public class BaseSpecs<T extends Base> {
    public BaseSpecs() {
    }

    public List<Predicate> basePredicates(Root<T> root, CriteriaBuilder builder, T criteria) {
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
        return predicates;
    }
}
