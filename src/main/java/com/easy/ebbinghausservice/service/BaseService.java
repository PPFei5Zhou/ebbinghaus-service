package com.easy.ebbinghausservice.service;

import org.springframework.data.domain.Page;

/**
 * Basic service interface.
 *
 * @author Easy
 */
public interface BaseService<T> {
    /**
     * 新增实体.
     *
     * @param model 要新增的实体
     * @return 新增后的实体
     */
    T insertEntity(T model);

    /**
     * 更新实体.
     *
     * @param model 要更新的实体（包含ID）
     * @return 更新后的实体
     * @throws RuntimeException model的ID属性的值为空
     */
    T updateEntity(T model);

    /**
     * 删除实体.
     *
     * @param id 要删除实体的ID
     */
    void removeEntity(String id);

    /**
     * 删除多个实体.
     *
     * @param ids 要删除实体的ID数组
     */
    void removeEntity(String[] ids);

    /**
     * 条件查询实体.
     *
     * @param model 查询条件
     * @param page 页码
     * @param size 每页数目
     * @return 分页结果、分页信息
     */
    Page<T> selectEntities(T model, int page, int size);

    /**
     * 查询实体.
     *
     * @param id 要查询实体的ID
     * @return 返回对应ID的实体
     */
    T selectEntityById(String id);
}
