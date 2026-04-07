package com.example.subcategory.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    public SubCategory save(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> findByName(String name) {
        return subCategoryRepository.findBySubCategoryNameStartingWithIgnoreCase(name);
    }

    public Optional<SubCategory> findById(int id) {
        return subCategoryRepository.findBySubCategoryId(id);
    }

    public List<SubCategory> findByCategoryId(int categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    public Optional<SubCategory> deleteById(int id) {

        Optional<SubCategory> subCategory =
                subCategoryRepository.findById(id);

        subCategory.ifPresent(subCategoryRepository::delete);

        return subCategory;
    }

    public Optional<SubCategory> updateSubCategory(int id, SubCategory subCategory) {

        Optional<SubCategory> optionalSubCategory =
                subCategoryRepository.findById(id);

        if (optionalSubCategory.isPresent()) {

            SubCategory existing = optionalSubCategory.get();

            existing.setCategoryId(subCategory.getCategoryId());
            existing.setSubCategoryName(subCategory.getSubCategoryName());
            existing.setSubCategoryImageLink(subCategory.getSubCategoryImageLink());

            subCategoryRepository.save(existing);
        }

        return optionalSubCategory;
    }
}
