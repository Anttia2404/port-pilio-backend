package com.example.demo.controller;

import com.example.demo.entity.Week;
import com.example.demo.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/weeks")
public class WeekController {

    @Autowired
    private WeekRepository weekRepository;

    @GetMapping
    public List<Week> getAllWeeks() {
        return weekRepository.findAll();
    }

    @PostMapping
    public Week createWeek(@RequestBody Week week) {
        return weekRepository.save(week);
    }

    @DeleteMapping("/{id}")
    public void deleteWeek(@PathVariable String id) {
        weekRepository.deleteById(id);
    }
}
