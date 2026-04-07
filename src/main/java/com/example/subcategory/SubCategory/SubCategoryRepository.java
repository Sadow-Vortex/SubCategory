package com.example.subcategory.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    List<SubCategory> findBySubCategoryNameStartingWithIgnoreCase(String name);

    List<SubCategory> findByCategoryId(Integer categoryId);

    Optional<SubCategory> findBySubCategoryId(Integer subCategoryId);
}
