package com.example.imt_tp_orienteur_2024.controller;
import com.example.imt_tp_orienteur_2024.model.Lesson;
import com.example.imt_tp_orienteur_2024.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.imt_tp_orienteur_2024.security.LessonNotFoundException;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;
    @GetMapping("/{id}")
    public Lesson findOne(@PathVariable Long id) {
        return lessonRepository.findById(id).orElseThrow(LessonNotFoundException::new);
    }
    @PostMapping("/creation")
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson createFromRequestParam(@RequestParam(name = "id") int id,
                                         @RequestParam(name = "title") String title,
                                         @RequestParam(name = "note") int note,
                                         @RequestParam(name = "teacher") String teacher){
        return lessonRepository.save(new Lesson(title,note,teacher));
    }
    @PostMapping("/creationFromJson")
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson create(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }

}

