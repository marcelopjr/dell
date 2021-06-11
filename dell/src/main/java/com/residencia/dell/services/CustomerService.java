package com.residencia.dell.services;

import com.residencia.dell.entities.Customer;
import com.residencia.dell.entities.Product;
import com.residencia.dell.repositories.CustomerRepository;
import com.residencia.dell.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;


    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Long count(){
        return customerRepository.count();
    }


    public ResponseEntity<Customer> save(Customer customer){
        HttpHeaders header = new HttpHeaders();
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<Customer>(customer, header, HttpStatus.OK);
    }

    public Boolean update(Long id, Customer customer){
        Customer atualizaCustomer = customerRepository.findById(id).get();
        atualizaCustomer.setCustomerId(customer.getCustomerId());
        atualizaCustomer.setAddres1(customer.getAddres1());
        atualizaCustomer.setAddres2(customer.getAddres2());
        atualizaCustomer.setAge(customer.getAge());
        atualizaCustomer.setCity(customer.getCity());
        atualizaCustomer.setCountry(customer.getCountry());
        atualizaCustomer.setCreditCard(customer.getCreditCard());
        atualizaCustomer.setCreditCardType(customer.getCreditCardType());
        atualizaCustomer.setCreditCardExpiration(customer.getCreditCardExpiration());
        atualizaCustomer.setEmail(customer.getEmail());
        atualizaCustomer.setFirstName(customer.getFirstName());
        atualizaCustomer.setLastName(customer.getLastName());
        atualizaCustomer.setPassWord(customer.getPassWord());
        customerRepository.save(atualizaCustomer);
        if (atualizaCustomer == customer)
            return true;
        else
            return false;
    }
    public Boolean delete(Long id){
        Customer droppedCustomer = customerRepository.getById(id);
        if(droppedCustomer.getCustomerId() != null){
            customerRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }
}
