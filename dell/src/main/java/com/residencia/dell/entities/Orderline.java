package com.residencia.dell.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "orderlines")
public class Orderline {

    @Id
    @Column(name = "orderlineid")
    private Long orderlineId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    private Order orderId;

    @Column(name = "prod_id")
    private Long prodId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "orderdate")
    private Calendar orderDate;

    public Long getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(Long orderlineId) {
        this.orderlineId = orderlineId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
}
