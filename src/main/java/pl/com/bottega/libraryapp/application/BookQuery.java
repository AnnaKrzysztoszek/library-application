package pl.com.bottega.libraryapp.application;

import java.time.LocalDateTime;

public class BookQuery {

    private String title;
    private String author;
    private LocalDateTime publishAfter;
    private LocalDateTime publishBefore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublishAfter() {
        return publishAfter;
    }

    public void setPublishAfter(LocalDateTime publishAfter) {
        this.publishAfter = publishAfter;
    }

    public LocalDateTime getPublishBefore() {
        return publishBefore;
    }

    public void setPublishBefore(LocalDateTime publishBefore) {
        this.publishBefore = publishBefore;
    }
}
