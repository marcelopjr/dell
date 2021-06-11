package com.residencia.dell.controllers;

import com.residencia.dell.entities.Order;
import com.residencia.dell.services.OrderService;
import com.residencia.dell.vo.NotaFiscalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscalVO> emiteNota(@PathVariable Long id){
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(orderService.emitirNota(id), header, HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(orderService.findById(id), headers, HttpStatus.OK);
    }*/

    @GetMapping
    public ResponseEntity<List<Order>> findAll(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(orderService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
    }
    /*@GetMapping("/listar-todos")
    public ResponseEntity<List<OrdersVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }*/

    @GetMapping("/count")
    public Long count(){
        return orderService.count();
    }

    @PostMapping
    public Order save(@RequestBody Order order){
        HttpHeaders header = new HttpHeaders();
        Order newOrder = orderService.save(order);
        if(order != null)
            return order;
        else
            return null;
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order){
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public Order delete(@PathVariable Long id){
         Order deletedOrder = orderService.findById(id);
         orderService.delete(id);
         return deletedOrder;

    }


}
