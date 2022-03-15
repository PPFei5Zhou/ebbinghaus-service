package com.easy.ebbinghausservice.service;

import org.springframework.data.domain.Page;

public interface InterfaceService<T> {
    /** 新增实体. */
    T insertEntity(T model);

    /** 更新实体. */
    T updateEntity(T model);

    /** 删除实体. */
    void removeEntity(String id);

    /** 删除多个实体. */
    void removeEntity(String[] ids);

    /** 条件查询实体. */
    Page<T> selectEntities(T model, int page, int size);

    /** 查询实体. */
    T selectEntityById(String id);
}
