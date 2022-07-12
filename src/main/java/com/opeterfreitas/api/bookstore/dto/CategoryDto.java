package com.opeterfreitas.api.bookstore.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
