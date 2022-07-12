package com.opeterfreitas.api.bookstore.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorDto {

    @NotBlank
    @Size(max = 130)
    private String name;
    @NotBlank
    @Email
    @Size(max = 130)
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

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
}
