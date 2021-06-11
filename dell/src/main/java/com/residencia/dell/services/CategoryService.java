package com.residencia.dell.services;

import com.residencia.dell.entities.Category;
import com.residencia.dell.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Long count(){
        return categoryRepository.count();
    }

    public Category save(Category category){
        Category newCategory = categoryRepository.save(category);
        if (newCategory.getCategoryId() != null)
            return newCategory;
        else
            return null;

    }

    public Boolean update(Long id, Category category){
        Category updateCategory = categoryRepository.getById(id);
        updateCategory.setCategoryId(category.getCategoryId());
        updateCategory.setCategoryName(category.getCategoryName());
        if(updateCategory == category)
            return true;
        else
            return false;
    }
}
