package com.example.demo.controller;

import com.example.demo.entity.Lesson;
import com.example.demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
