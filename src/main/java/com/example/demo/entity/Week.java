package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "week")
public class Week {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Lesson> exercises;

    public Week() {}

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

    public List<Lesson> getExercises() {
        return exercises;
    }

    public void setExercises(List<Lesson> exercises) {
        this.exercises = exercises;
    }
}
