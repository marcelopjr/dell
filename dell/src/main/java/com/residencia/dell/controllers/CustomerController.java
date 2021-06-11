package com.residencia.dell.controllers;

import com.residencia.dell.entities.Customer;
import com.residencia.dell.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(customerService.findById(id), header, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(customerService.findAll(), header, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count(){
        return customerService.count();
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        HttpHeaders header = new HttpHeaders();
        ResponseEntity<Customer> newCustomer = customerService.save(customer);
        if(newCustomer != null)
            return newCustomer;
        else
            return new ResponseEntity<>(customer, header, HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        HttpHeaders header = new HttpHeaders();
        if(customerService.update(id, customer))
            return new ResponseEntity<>(customerService.findById(id), header, HttpStatus.OK);
        else
            return new ResponseEntity<>(customerService.findById(id), header, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        HttpHeaders header = new HttpHeaders();
        Customer deletedCustomer = customerService.findById(id);
        if(customerService.delete(id))
            return new ResponseEntity<>(deletedCustomer, header, HttpStatus.OK);
        else
            return new ResponseEntity<>(deletedCustomer, header, HttpStatus.BAD_REQUEST);
    }


}
