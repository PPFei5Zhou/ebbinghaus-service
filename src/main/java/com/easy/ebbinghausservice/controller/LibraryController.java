package com.easy.ebbinghausservice.controller;

import com.easy.ebbinghausservice.model.entity.Library;
import com.easy.ebbinghausservice.model.request.LibraryRequestBody;
import com.easy.ebbinghausservice.service.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Library Controller.
 *
 * @author Easy
 */
@RestController
@RequestMapping("library")
public class LibraryController {
    @Resource
    public LibraryService service;

    /** 新增实体. */
    @PostMapping()
    public ResponseEntity<Library> insertEntity(@RequestBody LibraryRequestBody requestBody) {
        return ResponseEntity.ok(service.insertEntity(requestBody.createEntity()));
    }

    /** 更新实体. */
    @PutMapping("{id}")
    public ResponseEntity<Library> updateEntity(@PathVariable String id, @RequestBody LibraryRequestBody requestBody) {
        requestBody.setId(id);
        return ResponseEntity.ok(service.updateEntity(requestBody.createEntity()));
    }

    /** 删除实体. */
    @DeleteMapping("{id}")
    public ResponseEntity<Library> removeEntity(@PathVariable String id) {
        service.removeEntity(id);
        return ResponseEntity.ok().build();
    }

    /** 删除多个实体. */
    @DeleteMapping
    public ResponseEntity<Library> removeEntities(@RequestBody String[] ids) {
        service.removeEntity(ids);
        return ResponseEntity.ok().build();
    }

    /** 分页查询实体. */
    @GetMapping
    public ResponseEntity<Page<Library>> selectEntities(@RequestBody LibraryRequestBody requestBody, int page, int size) {
        Page<Library> libraryPage = service.selectEntities(requestBody.createEntity(), page, size);
        return ResponseEntity.ok(libraryPage);
    }

    /** 查询指定的实体. */
    @GetMapping("{id}")
    public ResponseEntity<Library> selectEntity(@PathVariable String id) {
        return ResponseEntity.ok(service.selectEntityById(id));
    }
}
