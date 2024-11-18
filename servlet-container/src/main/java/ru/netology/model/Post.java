package ru.netology.model;

public class Post {
    private long id;
    private String content;
    private boolean deleted;

    public Post() {
    }

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
        this.deleted = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
