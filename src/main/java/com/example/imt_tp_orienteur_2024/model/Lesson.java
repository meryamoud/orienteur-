package com.example.imt_tp_orienteur_2024.model;

import jakarta.persistence.*;
import static java.awt.PageAttributes.MediaType.C2;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private long note;
    @Column(nullable = false)
    private String teacher;
    public Lesson(String title, long note, String teacher) {
        this.title = title;
        this.note = note;
        this.teacher = teacher;
    }
    public Lesson() {
    }
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNote() {
        return note;
    }

    public void setNote(long note) {
        this.note = note;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}