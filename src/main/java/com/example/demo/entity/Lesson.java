package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.entity.Week;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;

@Entity
@Table(name = "lesson")
public class Lesson {
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "week_id")
    private Week week;

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "repo_link")
    private String repoLink;

    @Column(name = "deploy_link")
    private String deployLink;

    @Column(name = "is_viewed", nullable = false)
    private Boolean isViewed = false;

    @Column(name = "viewed_at")
    private LocalDateTime viewedAt;


    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRepoLink() {
        return repoLink;
    }

    public void setRepoLink(String repoLink) {
        this.repoLink = repoLink;
    }

    public String getDeployLink() {
        return deployLink;
    }

    public void setDeployLink(String deployLink) {
        this.deployLink = deployLink;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(Boolean isViewed) {
        this.isViewed = isViewed;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}
