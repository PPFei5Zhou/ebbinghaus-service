package com.easy.ebbinghausservice.service.impl;

import com.easy.ebbinghausservice.model.entity.Base;
import com.easy.ebbinghausservice.service.InterfaceService;
import com.easy.ebbinghausservice.utils.JpaUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.Optional;

public abstract class BaseService<B extends Base, J extends JpaRepository<B, String>> implements InterfaceService<B> {
    @Autowired
    @SuppressWarnings("all")
    public J jpa;

    @Override
    public B insertEntity(B model) {
        if (model == null) {
            throw new NullPointerException();
        }
        return jpa.save(model);
    }

    @Override
    public B updateEntity(B model) {
        if (model == null || Strings.isBlank(model.getId())) {
            throw new NullPointerException();
        }
        Optional<B> optional = jpa.findById(model.getId());
        if (optional.isPresent()) {
            JpaUtil.copyNotNullProperties(model, optional.get());
            return jpa.saveAndFlush(optional.get());
        }
        throw new NullPointerException();
    }

    @Override
    public void removeEntity(String id) {
        if (Strings.isBlank(id)) {
            throw new RuntimeException();
        }
        jpa.deleteById(id);
        jpa.flush();
    }

    @Override
    public void removeEntity(String[] ids) {
        if (ids == null || ids.length == 0) {
            throw new NullPointerException();
        }
        jpa.deleteAllByIdInBatch(Arrays.asList(ids));
        jpa.flush();
    }

    @Override
    public B selectEntityById(String id) {
        if (Strings.isBlank(id)) {
            throw new RuntimeException();
        }
        return jpa.getById(id);
    }
}
