package com.residencia.dell.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Category;
import com.residencia.dell.services.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@PostMapping
	public Category save(@Valid @RequestBody Category category) {
		HttpHeaders header = new HttpHeaders();
        Category newCategory = categoryService.save(category);
		return categoryService.save(category);
	}
	
	
}
