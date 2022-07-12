package com.opeterfreitas.api.bookstore.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 130)
    private String name;
    @Column(nullable = false, length = 130)
    private String email;
    @Column(nullable = false, length = 400)
    private String description;
    @Column(nullable = false)
    private LocalDateTime registrationMoment = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRegistrationMoment() {
        return registrationMoment;
    }

    public void setRegistrationMoment(LocalDateTime registrationMoment) {
        this.registrationMoment = registrationMoment;
    }
}
