package com.easy.ebbinghausservice.model.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Knowledge.
 *
 * @author Easy
 */
@Entity
public class Knowledge extends Base {
    private String title;
    private String subtitle;
    private String content;
    @Column(name = "library_id")
    private String libraryId;

    public static Knowledge ofCreated(String title, String subtitle, String content, String libraryId) {
        return new Knowledge(null, title, subtitle, content, libraryId, null, null);
    }

    public static Knowledge ofUpdate(String id, String title, String subtitle, String content, String libraryId) {
        return new Knowledge(id, title, subtitle, content, libraryId, null, null);
    }

    public static Knowledge sqlCondition(String id, String title, String subtitle, String content, String libraryId) {
        return new Knowledge(id, title, subtitle, content, libraryId, null, null);
    }

    @PersistenceConstructor
    protected Knowledge() {
    }

    private Knowledge(String id, String title, String subtitle, String content, String libraryId,
                     Timestamp createDate, Timestamp updateDate) {
        super(id, createDate, updateDate);
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.libraryId = libraryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knowledge)) {
            return false;
        }
        Knowledge knowledge = (Knowledge) o;
        return Objects.equals(getTitle(), knowledge.getTitle())
                && Objects.equals(getSubtitle(), knowledge.getSubtitle())
                && Objects.equals(getContent(), knowledge.getContent())
                && Objects.equals(getLibraryId(), knowledge.getLibraryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSubtitle(), getContent(), getLibraryId());
    }
}
