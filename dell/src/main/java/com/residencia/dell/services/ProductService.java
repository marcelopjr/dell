package com.residencia.dell.services;

import com.residencia.dell.entities.Product;
import com.residencia.dell.repositories.ProductRepository;
import com.residencia.dell.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;


    public ProductVO findById(Long id){
        ProductVO productVO = entidadeParaVO(productRepository.findById(id).get());
        return productVO;
    }

    public List<Product> findAll() {
        return productRepository.findAll();

    }
    public List<ProductVO> findAllVO(){
        List<ProductVO> listProductVO = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        listProduct = productRepository.findAll();
        // para cada Produto, na lista de produtos, guarde o produto ja convertido na listaProductsVO.
        for (Product product : listProduct) {
            listProductVO.add(entidadeParaVO(product));
        }
        return listProductVO;
    }

    public Long count(){
        return productRepository.count();
    }

    public boolean save(Product product) { //request body no controller
        Product newProduct = productRepository.save(product);
        if(newProduct.getProdId() != null)
            return true;
        else
            return false;
    }

    public Boolean update(Long id, Product product){
        Product atualizaProduct = productRepository.findById(id).get();
        atualizaProduct.setActor(product.getActor());
        atualizaProduct.setCategory(product.getCategory());
        atualizaProduct.setTitle(product.getTitle());
        atualizaProduct.setSpecial(product.getSpecial());
        atualizaProduct.setCommonProdId(product.getCommonProdId());
        atualizaProduct.setPrice(product.getPrice());
        atualizaProduct.setProdId(product.getProdId());
        productRepository.save(atualizaProduct);
        if (atualizaProduct == product)
            return true;
        else
            return false;
    }

    public Boolean delete(Long id) {
        Product droppedProduct = productRepository.getById(id);
        if (droppedProduct.getProdId() != null) {
            productRepository.deleteById(id);
            return true;
            }
        else
            return false;

        }


    public ProductVO entidadeParaVO(Product product){
        ProductVO productVO = new ProductVO();
        productVO.setProdId(product.getProdId());
        productVO.setCategory(product.getCategory());
        return productVO;
    }


}



