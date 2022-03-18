package com.easy.ebbinghausservice.model.request;

import com.easy.ebbinghausservice.model.entity.Library;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LibraryRequestBody)) {
            return false;
        }

        LibraryRequestBody that = (LibraryRequestBody) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getLibraryName(),
                that.getLibraryName()).append(getLibraryParentId(),
                that.getLibraryParentId()).append(getLibraryOwnerId(), that.getLibraryOwnerId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getLibraryName())
                .append(getLibraryParentId()).append(getLibraryOwnerId()).toHashCode();
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
