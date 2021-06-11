package com.residencia.dell.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private Long orderId;

    @JsonManagedReference
    @OneToMany(mappedBy = "orderId")
    private List<Orderline> listOrderline;

    @Column(name = "orderdate")
    private Calendar orderDate;

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customer customer;

    @Column(name = "netamount")
    private BigDecimal netAmount;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "totalamount")
    private BigDecimal totalAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Orderline> getListOrderline() {
        return listOrderline;
    }

    public void setListOrderline(List<Orderline> listOrderline) {
        this.listOrderline = listOrderline;
    }
}


