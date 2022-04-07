package com.easy.ebbinghausservice.model.request;

import com.easy.ebbinghausservice.model.entity.Library;
import com.easy.ebbinghausservice.model.enums.JpaEntityType;

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

    public Library createEntity(JpaEntityType type) {
        switch (type) {
            case INSERT:
                return Library.ofCreate(libraryName, libraryDescription, libraryParentId, libraryOwnerId);
            case UPDATE:
                return Library.ofUpdate(super.getId(), libraryName, libraryDescription, libraryParentId, libraryOwnerId);
            default:
                return Library.sqlCondition(super.getId(), libraryName, libraryDescription, libraryParentId,
                        libraryOwnerId, super.getCreateDate(), super.getUpdateDate());
        }
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
