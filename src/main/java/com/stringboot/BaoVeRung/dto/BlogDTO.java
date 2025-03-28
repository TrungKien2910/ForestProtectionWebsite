package com.stringboot.BaoVeRung.dto;

import java.time.LocalDateTime;

public class BlogDTO {
    private Integer blogId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public BlogDTO(Integer blogId, String username, String title, String content, LocalDateTime createdAt) {
        this.blogId = blogId;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return String.format("BlogId: %d, UserName: %s, Title: %s, Content: %s, CreatedAt: %s",
                blogId, username, title, content, createdAt);
    }

    // Getter & Setter
    public Integer getBlogId() { return blogId; }
    public void setBlogId(Integer blogId) { this.blogId = blogId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
