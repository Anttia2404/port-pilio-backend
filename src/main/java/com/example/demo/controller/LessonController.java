package com.example.demo.controller;

import com.example.demo.entity.Lesson;
import com.example.demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable String id) {
        lessonRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable String id, @RequestBody Lesson updatedLesson) {
        updatedLesson.setId(id);
        return lessonRepository.save(updatedLesson);
    }

    @PutMapping("/{id}/viewed")
    public ResponseEntity<Lesson> toggleViewedStatus(
            @PathVariable String id,
            @RequestBody Map<String, Boolean> body) {

        Optional<Lesson> lessonOpt = lessonRepository.findById(id);

        if (!lessonOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Lesson lesson = lessonOpt.get();
        Boolean isViewed = body.get("isViewed");

        lesson.setIsViewed(isViewed);
        lesson.setViewedAt(isViewed ? LocalDateTime.now() : null);

        Lesson updated = lessonRepository.save(lesson);
        return ResponseEntity.ok(updated);
    }
}
