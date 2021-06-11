package com.residencia.dell.services;

import com.residencia.dell.entities.CustHist;
import com.residencia.dell.repositories.CustHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class CustHistService {

    @Autowired
    public CustHistRepository custHistRepository;

    public CustHist findById(Long id){
        return custHistRepository.findById(id).get();
    }
    public List<CustHist> findAll(){
        return custHistRepository.findAll();
    }
}
