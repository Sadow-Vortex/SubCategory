package com.example.subcategory.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    public Optional<Category> deleteById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(categoryRepository::delete);
        return category;
    }

    public Optional<Category> updateCategory(int id, Category category) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category existing = optionalCategory.get();
            existing.setCategoryName(category.getCategoryName());
            existing.setImageLink(category.getImageLink());
            categoryRepository.save(existing);
        }

        return optionalCategory;
    }
}
