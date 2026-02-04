package com.example.subcategory.SubCategory;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subCategoryId;

    private Integer categoryId;

    private String subCategoryName;

    private String subCategoryImageLink;

    public SubCategory() {
    }

    public SubCategory(Integer categoryId,
                       String subCategoryName,
                       String subCategoryImageLink) {
        this.categoryId = categoryId;
        this.subCategoryName = subCategoryName;
        this.subCategoryImageLink = subCategoryImageLink;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryImageLink() {
        return subCategoryImageLink;
    }

    public void setSubCategoryImageLink(String subCategoryImageLink) {
        this.subCategoryImageLink = subCategoryImageLink;
    }
}
