package com.easy.ebbinghausservice.model.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedAttributeNode;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * Library jpa entity.
 *
 * @author Easy
 */
@Entity
@NamedEntityGraph(name = "Library.Graph", attributeNodes = {
    @NamedAttributeNode(value = "knowledgeSet"),
    @NamedAttributeNode(value = "libraries")
})
public class Library extends Base {
    private String libraryName;
    private String libraryDescription;
    @Column(name = "library_parent_id")
    private String libraryParentId;
    private String libraryOwnerId;

    @OneToMany(targetEntity = Knowledge.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Set<Knowledge> knowledgeSet;

    @OneToMany(targetEntity = Library.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_parent_id")
    private Set<Library> libraries;

    @PersistenceConstructor
    protected Library() {
        super();
    }

    private Library(String id, String libraryName, String libraryDescription, String libraryParentId, String libraryOwnerId,
                   Timestamp createDate, Timestamp updateDate) {
        super(id, createDate, updateDate);
        this.libraryName = libraryName;
        this.libraryDescription = libraryDescription;
        this.libraryParentId = libraryParentId;
        this.libraryOwnerId = libraryOwnerId;
    }

    public static Library ofCreate(String libraryName, String libraryDescription, String libraryParentId,
                                   String libraryOwnerId) {
        return new Library(null, libraryName, libraryDescription, libraryParentId, libraryOwnerId, null, null);
    }

    public static Library ofUpdate(String id, String libraryName, String libraryDescription, String libraryParentId,
                                   String libraryOwnerId) {
        return new Library(id, libraryName, libraryDescription, libraryParentId, libraryOwnerId, null, null);
    }

    public static Library sqlCondition(String id, String libraryName, String libraryDescription, String libraryParentId,
                                       String libraryOwnerId, Timestamp createDate, Timestamp updateDate) {
        return new Library(id, libraryName, libraryDescription, libraryParentId, libraryOwnerId, createDate, updateDate);
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

    public Set<Knowledge> getKnowledgeSet() {
        return knowledgeSet;
    }

    public void setKnowledgeSet(Set<Knowledge> knowledgeSet) {
        this.knowledgeSet = knowledgeSet;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Library)) {
            return false;
        }
        Library library = (Library) o;
        return Objects.equals(getLibraryName(), library.getLibraryName())
                && Objects.equals(getLibraryDescription(), library.getLibraryDescription())
                && Objects.equals(getLibraryParentId(), library.getLibraryParentId())
                && Objects.equals(getLibraryOwnerId(), library.getLibraryOwnerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLibraryName(), getLibraryDescription(), getLibraryParentId(), getLibraryOwnerId());
    }

    @Override
    public String toString() {
        return "Library{"
                + "libraryName='" + libraryName + '\''
                + ", libraryDescription='" + libraryDescription + '\''
                + ", libraryParentId='" + libraryParentId + '\''
                + ", libraryOwnerId='" + libraryOwnerId + '\''
                + ", knowledgeSet=" + knowledgeSet
                + ", libraries=" + libraries
                + "} " + super.toString();
    }
}
