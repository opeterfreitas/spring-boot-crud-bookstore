package com.opeterfreitas.api.bookstore.controllers;

import com.opeterfreitas.api.bookstore.dto.AuthorDto;
import com.opeterfreitas.api.bookstore.models.Author;
import com.opeterfreitas.api.bookstore.services.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Long id) {
        Optional<Author> authorOptional = authorService.findById(id);
        if (!authorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author is not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid AuthorDto authorDto) {
        Optional<Author> authorOptional = authorService.findById(id);
        if (!authorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author is not found.");
        }
        var author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        author.setId(authorOptional.get().getId());
        author.setRegistrationMoment(authorOptional.get().getRegistrationMoment());
        return ResponseEntity.status(HttpStatus.OK).body(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Optional<Author> authorOptional = authorService.findById(id);
        if (!authorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author is not found.");
        }
        authorService.delete(authorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

}
