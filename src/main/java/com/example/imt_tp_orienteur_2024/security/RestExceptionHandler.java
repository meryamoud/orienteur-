package com.example.imt_tp_orienteur_2024.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ LessonNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Lesson not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ LessonByIdNotFoundException.class }) // Modifier pour gérer la nouvelle exception
    protected ResponseEntity<Object> handleLessonByIdNotFound(
            LessonByIdNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Lesson by id not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
