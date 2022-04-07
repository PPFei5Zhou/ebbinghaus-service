package com.easy.ebbinghausservice.controller.api;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import com.easy.ebbinghausservice.model.request.KnowledgeRequestBody;
import com.easy.ebbinghausservice.model.request.KnowledgeRequestBody.JpaEntityType;
import com.easy.ebbinghausservice.model.response.Paginate;
import com.easy.ebbinghausservice.service.KnowledgeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.Resource;

/**
 * Knowledge controller.
 *
 * @author Easy
 */
@RestController
@RequestMapping("api/knowledge")
public class KnowledgeController {
    @Resource
    private KnowledgeService service;

    /** 新增实体. */
    @PostMapping
    public ResponseEntity<Knowledge> insertEntity(@RequestBody KnowledgeRequestBody requestBody) {
        return ResponseEntity.ok(service.insertEntity(requestBody.getJpaEntity(JpaEntityType.INSERT)));
    }

    /** 更新实体. */
    @PutMapping("{id}")
    public ResponseEntity<Knowledge> updateEntity(@PathVariable String id, @RequestBody KnowledgeRequestBody requestBody) {
        requestBody.setId(id);
        var knowledge = requestBody.getJpaEntity(JpaEntityType.UPDATE);
        return ResponseEntity.ok(service.updateEntity(knowledge));
    }

    /** 删除实体. */
    @DeleteMapping("{id}")
    public ResponseEntity<Knowledge> removeEntity(@PathVariable String id) {
        service.removeEntity(id);
        return ResponseEntity.ok().build();
    }

    /** 删除多个实体. */
    @DeleteMapping
    public ResponseEntity<Knowledge> removeEntities(@RequestBody String[] ids) {
        service.removeEntity(ids);
        return ResponseEntity.ok().build();
    }

    /** 查询指定的实体. */
    @GetMapping("{id}")
    public ResponseEntity<Knowledge> selectEntity(@PathVariable String id) {
        return ResponseEntity.ok(service.selectEntityById(id));
    }

    /** 分页查询实体. */
    @GetMapping
    public ResponseEntity<Paginate<Knowledge>> selectEntities(KnowledgeRequestBody requestBody) {
        Page<Knowledge> knowledgePage = service
                .selectEntities(
                        requestBody.getJpaEntity(JpaEntityType.SEARCH),
                        requestBody.getPage(),
                        requestBody.getSize());

        if (knowledgePage == null) {
            return ResponseEntity.ok(Paginate.build(1, 0, 0, null));
        }

        Pageable pageable = knowledgePage.getPageable();
        return ResponseEntity.ok(Paginate.build(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                knowledgePage.getTotalElements(),
                knowledgePage.getContent()));
    }
}
