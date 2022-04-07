package com.easy.ebbinghausservice.model.request;

import com.easy.ebbinghausservice.model.entity.Library;

/**
 * Library request body model.
 *
 * @author Easy
 */
public class LibraryRequestBody extends BaseRequestBody {
    private String libraryName;
    private String libraryDescription;
    private String libraryParentId;
    private String libraryOwnerId;

    public Library createEntity() {
        Library library = new Library(this.getLibraryName(), this.getLibraryDescription(),
                this.getLibraryParentId(), this.getLibraryOwnerId(), super.getCreateDate(), super.getUpdateDate());
        library.setId(this.getId());
        return library;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryDescription() {
        return libraryDescription;
    }

    public void setLibraryDescription(String libraryDescription) {
        this.libraryDescription = libraryDescription;
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
