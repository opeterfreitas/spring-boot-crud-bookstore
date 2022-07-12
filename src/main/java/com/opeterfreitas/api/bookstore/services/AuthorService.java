package com.opeterfreitas.api.bookstore.services;

import com.opeterfreitas.api.bookstore.models.Author;
import com.opeterfreitas.api.bookstore.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public boolean existsByEmail(String email) {
        return authorRepository.existsByEmail(email);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}