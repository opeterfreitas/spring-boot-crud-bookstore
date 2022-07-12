package com.opeterfreitas.api.bookstore.repositories;

import com.opeterfreitas.api.bookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
