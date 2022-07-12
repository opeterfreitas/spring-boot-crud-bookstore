package com.opeterfreitas.api.bookstore.services;

import com.opeterfreitas.api.bookstore.models.Author;
import com.opeterfreitas.api.bookstore.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author save(Author author){
        return authorRepository.save(author);
    }

}
