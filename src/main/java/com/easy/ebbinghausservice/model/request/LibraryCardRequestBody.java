package com.easy.ebbinghausservice.model.request;

import com.easy.ebbinghausservice.model.entity.LibraryCard;

/**
 * Library Card request body.
 *
 * @author Easy
 */
public class LibraryCardRequestBody extends BaseRequestBody {
    private String cardTitle;
    private String cardSubtitle;
    private String cardContent;
    private String libraryId;

    public LibraryCard createEntity() {
        return new LibraryCard(this.getId(), this.getCardTitle(), this.getCardSubtitle(), this.getCardContent(),
                this.getLibraryId(), super.getCreateDate(), super.getUpdateDate());
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
