package com.example.subcategory.SubCategory;

import com.example.subcategory.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubCategory>>> findAll() {

        List<SubCategory> subCategories =
                subCategoryService.findAll();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        subCategories
                )
        );
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<ApiResponse<List<SubCategory>>> findByCategoryId(
            @PathVariable int categoryId) {

        List<SubCategory> subCategories =
                subCategoryService.findByCategoryId(categoryId);

        if (subCategories.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "SubCategory not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        subCategories
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SubCategory>> create(
            @RequestBody SubCategory subCategory) {

        SubCategory savedSubCategory =
                subCategoryService.save(subCategory);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        savedSubCategory
                )
        );
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<ApiResponse<SubCategory>> findByName(
            @PathVariable String name) {

        Optional<SubCategory> subCategory =
                subCategoryService.findByName(name);

        if (subCategory.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "SubCategory not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        subCategory.get()
                )
        );
    }

    @GetMapping("/SubCategory/{id}")
    public ResponseEntity<ApiResponse<SubCategory>> findById(@PathVariable int id) {
        Optional<SubCategory> subCategory= subCategoryService.findById(id);
        if (subCategory.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "SubCategory not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        subCategory.get()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SubCategory>> deleteById(
            @PathVariable int id) {

        Optional<SubCategory> subCategory =
                subCategoryService.deleteById(id);

        if (subCategory.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "SubCategory not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Deleted successfully",
                        subCategory.get()
                )
        );
    }
}
