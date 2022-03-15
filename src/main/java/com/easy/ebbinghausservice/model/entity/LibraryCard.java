package com.easy.ebbinghausservice.model.entity;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class LibraryCard extends Base {
    private String cardTitle;
    private String cardSubtitle;
    private String cardContent;
    private String libraryId;

    protected LibraryCard() {
        super();
    }

    public LibraryCard(String cardTitle, String cardSubtitle, String cardContent, String libraryId,
                       Timestamp createDate, Timestamp updateDate) {
        super(createDate, updateDate);
        this.cardTitle = cardTitle;
        this.cardSubtitle = cardSubtitle;
        this.cardContent = cardContent;
        this.libraryId = libraryId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardSubtitle() {
        return cardSubtitle;
    }

    public void setCardSubtitle(String cardSubtitle) {
        this.cardSubtitle = cardSubtitle;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }
}
