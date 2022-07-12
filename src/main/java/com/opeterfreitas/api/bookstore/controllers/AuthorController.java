package com.opeterfreitas.api.bookstore.controllers;

import com.opeterfreitas.api.bookstore.dto.AuthorDto;
import com.opeterfreitas.api.bookstore.models.Author;
import com.opeterfreitas.api.bookstore.services.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore/authors")
public class AuthorController {

    final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AuthorDto authorDto) {
        if (authorService.existsByEmail(authorDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
        }
        var author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.save(author));
    }

}
