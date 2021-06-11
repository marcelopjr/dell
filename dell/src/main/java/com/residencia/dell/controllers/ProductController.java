package com.residencia.dell.controllers;

import com.residencia.dell.entities.Product;
import com.residencia.dell.services.ProductService;
import com.residencia.dell.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductVO> findById(@PathVariable Long id){
        HttpHeaders header = new HttpHeaders();
        ProductVO novoVO = productService.findById(id);
        if(novoVO != null)
            return new ResponseEntity<>(novoVO, header, HttpStatus.OK);
        else
            return new ResponseEntity<>(novoVO, header, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<ProductVO>> findAll(){
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(productService.findAllVO(), header, HttpStatus.OK);
    }
}
