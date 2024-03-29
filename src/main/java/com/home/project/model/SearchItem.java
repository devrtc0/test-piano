package com.home.project.model;

import com.home.project.model.stack_exchange.Question;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class SearchItem {
    private int answerCount;
    private String title;
    private String link;
    private LocalDateTime creationDate;
    private String publisherName;
    private String publisherImage;
    private String publisherLink;
    private boolean isAnswerAccepted;

    public boolean isAnswerAccepted() {
        return isAnswerAccepted;
    }

    public void setAnswerAccepted(boolean answerAccepted) {
        isAnswerAccepted = answerAccepted;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherImage() {
        return publisherImage;
    }

    public void setPublisherImage(String publisherImage) {
        this.publisherImage = publisherImage;
    }

    public String getPublisherLink() {
        return publisherLink;
    }

    public void setPublisherLink(String publisherLink) {
        this.publisherLink = publisherLink;
    }

    public static SearchItem from(Question q) {
        SearchItem item = new SearchItem();

        item.setAnswerCount(q.getAnswerCount());
        if (q.getCreationDate() != null) {
            item.setCreationDate(LocalDateTime.ofEpochSecond(q.getCreationDate(), 0, ZoneOffset.UTC));
        }
        item.setLink(q.getLink());
        item.setTitle(q.getTitle());
        if (q.getOwner() != null) {
            item.setPublisherName(q.getOwner().getName());
            item.setPublisherLink(q.getOwner().getLink());
            item.setPublisherImage(q.getOwner().getImage());
        }
        item.setAnswerAccepted(q.getAcceptedAnswerId() != null);

        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchItem item = (SearchItem) o;
        return answerCount == item.answerCount &&
                isAnswerAccepted == item.isAnswerAccepted &&
                Objects.equals(title, item.title) &&
                Objects.equals(link, item.link) &&
                Objects.equals(creationDate, item.creationDate) &&
                Objects.equals(publisherName, item.publisherName) &&
                Objects.equals(publisherImage, item.publisherImage) &&
                Objects.equals(publisherLink, item.publisherLink);
    }

    @Override
    public int hashCode() {

        return Objects.hash(answerCount, title, link, creationDate, publisherName, publisherImage, publisherLink, isAnswerAccepted);
    }
}
