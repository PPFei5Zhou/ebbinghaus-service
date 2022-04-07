package com.easy.ebbinghausservice.model.request;

import com.easy.ebbinghausservice.model.entity.Knowledge;
import com.easy.ebbinghausservice.model.enums.JpaEntityType;

/**
 * Knowledge request body.
 *
 * @author Easy
 */
public class KnowledgeRequestBody extends BaseRequestBody {
    private String title;
    private String subtitle;
    private String content;
    private String libraryId;

    public Knowledge getJpaEntity(JpaEntityType jpaEntityType) {
        if (jpaEntityType.equals(JpaEntityType.INSERT)) {
            return Knowledge.ofCreated(this.title, this.subtitle, this.content, this.libraryId);
        } else if (jpaEntityType.equals(JpaEntityType.UPDATE)) {
            return Knowledge.ofUpdate(super.getId(), this.title, this.subtitle, this.content, this.libraryId);
        } else {
            return Knowledge.sqlCondition(super.getId(), this.title, this.subtitle, this.content, this.libraryId);
        }
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
}
