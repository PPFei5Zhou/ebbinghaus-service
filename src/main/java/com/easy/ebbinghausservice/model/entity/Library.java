package com.easy.ebbinghausservice.model.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
@Proxy(lazy = false)
public class Library extends Base {
    private String libraryName;
    private String libraryParentId;
    private String libraryOwnerId;

    protected Library() {
        super();
    }

    public Library(String libraryName, String libraryParentId, String libraryOwnerId,
                   Timestamp createDate, Timestamp updateDate) {
        super(createDate, updateDate);
        this.libraryName = libraryName;
        this.libraryParentId = libraryParentId;
        this.libraryOwnerId = libraryOwnerId;
    }

    public Library(String id, String libraryName, String libraryParentId, String libraryOwnerId) {
        super(id);
        this.libraryName = libraryName;
        this.libraryParentId = libraryParentId;
        this.libraryOwnerId = libraryOwnerId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryParentId() {
        return libraryParentId;
    }

    public void setLibraryParentId(String libraryParentId) {
        this.libraryParentId = libraryParentId;
    }

    public String getLibraryOwnerId() {
        return libraryOwnerId;
    }

    public void setLibraryOwnerId(String libraryOwnerId) {
        this.libraryOwnerId = libraryOwnerId;
    }

}
