package com.opeterfreitas.api.bookstore.services;

import com.opeterfreitas.api.bookstore.models.Category;
import com.opeterfreitas.api.bookstore.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public boolean existsByName(String name){
        return categoryRepository.existsByName(name);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }

}
