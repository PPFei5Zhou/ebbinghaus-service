package com.easy.ebbinghausservice.controller.api;

import com.easy.ebbinghausservice.model.entity.LibraryCard;
import com.easy.ebbinghausservice.model.request.LibraryCardRequestBody;
import com.easy.ebbinghausservice.service.LibraryCardService;
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

/**
 * Library Card controller.
 *
 * @author Easy
 */
@RestController
@RequestMapping("api/libraryCard")
public class LibraryCardController {

    private final LibraryCardService service;

    public LibraryCardController(LibraryCardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LibraryCard> insertEntity(@RequestBody LibraryCardRequestBody requestBody) {
        return ResponseEntity.ok(service.insertEntity(requestBody.createEntity()));
    }

    @PutMapping("{id}")
    public ResponseEntity<LibraryCard> updateEntity(@PathVariable String id, @RequestBody LibraryCardRequestBody requestBody) {
        requestBody.setId(id);
        return ResponseEntity.ok(service.updateEntity(requestBody.createEntity()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LibraryCard> removeEntity(@PathVariable String id) {
        service.removeEntity(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<LibraryCard> removeEntities(@RequestBody String[] ids) {
        service.removeEntity(ids);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryCard> selectEntity(@PathVariable String id) {
        return ResponseEntity.ok(service.selectEntityById(id));
    }

    @GetMapping
    public ResponseEntity<Page<LibraryCard>> selectEntities(@RequestBody LibraryCardRequestBody requestBody, int page, int size) {
        return ResponseEntity.ok(service.selectEntities(requestBody.createEntity(), page, size));
    }
}
