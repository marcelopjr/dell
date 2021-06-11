package com.residencia.dell.services;

import com.residencia.dell.entities.Orderline;
import com.residencia.dell.entities.Product;
import com.residencia.dell.repositories.OrderlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlineService {

    @Autowired
    public OrderlineRepository orderlineRepository;


    public List<Orderline> findAll() {
        return orderlineRepository.findAll();

    }

    public Long count(){
        return orderlineRepository.count();
    }




}
