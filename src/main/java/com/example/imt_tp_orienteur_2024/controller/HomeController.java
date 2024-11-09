package com.example.imt_tp_orienteur_2024.controller;

import com.example.imt_tp_orienteur_2024.model.Lesson;
import com.example.imt_tp_orienteur_2024.security.LessonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.imt_tp_orienteur_2024.repositories.LessonRepository;
import com.example.imt_tp_orienteur_2024.security.LessonByIdNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HomeController {
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/home")
    public String  getHomePage(){
        return "home";
    }

    @GetMapping("/showById")
    public String showById(@RequestParam Long id, Model model) {
        Lesson lessonFound = lessonRepository.findById(id).orElseThrow(LessonByIdNotFoundException::new); // Recherche la leçon par son ID
        model.addAttribute("lessonFound", lessonFound);  // Ajoute la leçon au modèle
        return "lessonDetails";
    }


    @GetMapping("/showAll")
    public String showAll(Model model) {
        Iterable<Lesson> lessons = lessonRepository.findAll();  // Récupère toutes les leçons
        model.addAttribute("lessons", lessons);  // Ajoute les leçons au modèle
        return "lessonsList";  // Retourne le nom de la vue (le fichier HTML)
    }

    @GetMapping("/lessonForm")
    public String lessonForm(Model model){
        model.addAttribute("formContent", new Lesson());
        return "createLesson";
    }

    @PostMapping("/createLesson")
    public String createLesson(@ModelAttribute Lesson lesson, Model model) {
        if (lesson.getTitle() == null || lesson.getTitle().isEmpty()) {
            model.addAttribute("error", "Le titre ne peut pas être vide");
            return "createLesson";
        }

        lessonRepository.save(lesson);
        return "redirect:/showAll";
    }


    @GetMapping("/sortAll")
    public String sortAll(Model model) {
        // Récupère toutes les leçons
        Iterable<Lesson> lessons = lessonRepository.findAll();

        // Convertit Iterable en List et trie par note
        List<Lesson> sortedLessons = StreamSupport.stream(lessons.spliterator(), false)
                .sorted(Comparator.comparingLong(Lesson::getNote))
                .collect(Collectors.toList());

        // Ajoute les leçons triées au modèle
        model.addAttribute("lessons", sortedLessons);
        return "lessonsList";  // Retourne le nom de la vue (le fichier HTML)
    }
}

