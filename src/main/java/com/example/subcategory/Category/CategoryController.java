package com.example.subcategory.Category;

import com.example.subcategory.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> findAll() {

        List<Category> categories = categoryService.findAll();

        ApiResponse<List<Category>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                categories
        );

        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Category>> create(@RequestBody Category category) {

        Category savedCategory = categoryService.save(category);

        ApiResponse<Category> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                savedCategory
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<ApiResponse<List<Category>>> findByName(@PathVariable String name) {

        List<Category> category = categoryService.findByName(name);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        category
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Category>> update(@PathVariable int id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByCategoryId(id);
        if (categoryOptional.isPresent()) {
            Optional<Category> categoryToUpdate = categoryService.updateCategory(id, category);
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.OK.value(),
                            "Category updated",
                            categoryToUpdate.get()
                    )
            );
        }
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.NOT_FOUND.value(),
                        "Category not found",
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> deleteById(@PathVariable int id) {

        Optional<Category> category = categoryService.deleteById(id);

        if (category.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "Category not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Deleted successfully",
                        category.get()
                )
        );
    }
}
