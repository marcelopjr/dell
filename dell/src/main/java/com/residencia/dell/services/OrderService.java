package com.residencia.dell.services;

import com.residencia.dell.entities.Order;
import com.residencia.dell.entities.Orderline;
import com.residencia.dell.repositories.OrderRepository;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderVO;
import com.residencia.dell.vo.OrderlineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;


    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Long count(){
        return orderRepository.count();
    }

    public void delete(Long id){
         orderRepository.deleteById(id);
    }

    public Order save(Order order){
       Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    public NotaFiscalVO emitirNota(Long orderId){
        NotaFiscalVO notaVO = new NotaFiscalVO();
        Order order = orderRepository.getById(orderId);

        notaVO.setOrderId(order.getOrderId());
        notaVO.setCustomerFirstName(order.getCustomer().getFirstName());
        notaVO.setCustomerLastname(order.getCustomer().getLastName());
        notaVO.setListOrderline(order.getListOrderline());
        notaVO.setTotalAmount(order.getTotalAmount());

        return notaVO;
    }

    public Order update(Long id, Order order){
        Order updatedOrder = orderRepository.findById(id).get();

        updatedOrder.setOrderDate(order.getOrderDate());
        updatedOrder.setCustomer(order.getCustomer());
        updatedOrder.setNetAmount(order.getNetAmount());
        updatedOrder.setTax(order.getTax());
        updatedOrder.setTotalAmount(order.getTotalAmount());
        return orderRepository.save(updatedOrder);
    }



   /* public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Orders> listOrders = null;
        List<Orders> listOrdersComPaginacao = null;
        List<OrdersVO> listOrdersVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

                for (Orders lOrders : listOrdersComPaginacao) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrders));
                }

            } else {
                listOrders = ordersRepository.findAll();

                for (Orders lOrders : listOrders) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrders));
                }

            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }

        return listOrdersVO;
    }*/

    public List<Order> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
        PageRequest page = null;
        List<Order> listOrders = null;
        List<Order> listOrdersComPaginacao = null;

        try {
            if (null != pagina && null != qtdRegistros) {
                page = PageRequest.of(pagina, qtdRegistros);
                listOrdersComPaginacao = orderRepository.findAll(page).getContent();

                return listOrdersComPaginacao;
            } else {
                listOrders = orderRepository.findAll();

                return listOrders;
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
    }

    public OrderVO entidadeParaVO(Order order){
        OrderVO orderVO = new OrderVO();
        List<OrderlineVO> listOrderlineVO = new ArrayList<>();

        orderVO.setNetAmount(order.getNetAmount());
        orderVO.setOrderDate(order.getOrderDate());
        orderVO.setOrderId(order.getOrderId());
        orderVO.setTax(order.getTax());
        orderVO.setTotalAmount(order.getTotalAmount());

        for(Orderline orderline : order.getListOrderline()){
             OrderlineVO orderlineVO = new OrderlineVO();

             orderlineVO.setOrderDate(orderline.getOrderDate());
             orderlineVO.setOrderlineId(orderline.getOrderlineId());
             orderlineVO.setProdId(orderline.getProdId());
             orderlineVO.setQuantity(orderline.getQuantity());

             listOrderlineVO.add(orderlineVO);
        }
        orderVO.setListorderLinesVO(listOrderlineVO);
        return orderVO;
    }

}
