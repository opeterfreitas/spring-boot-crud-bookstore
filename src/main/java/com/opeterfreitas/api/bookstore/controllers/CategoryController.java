package com.opeterfreitas.api.bookstore.controllers;

import com.opeterfreitas.api.bookstore.dto.CategoryDto;
import com.opeterfreitas.api.bookstore.models.Category;
import com.opeterfreitas.api.bookstore.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore/categories")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CategoryDto categoryDto) {
        if (categoryService.existsByName(categoryDto.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Category is already in use!");
        }
        var category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        var category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category.setId(categoryOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        categoryService.delete(categoryOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully.");
    }

}
