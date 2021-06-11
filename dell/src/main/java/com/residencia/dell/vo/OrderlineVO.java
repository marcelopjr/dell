package com.residencia.dell.vo;

import java.util.Calendar;

public class OrderlineVO {
    private Long orderlineId;
    private OrderVO orderVO;
    private Long prodId;
    private Integer quantity;
    private Calendar orderDate;

    public Long getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(Long orderlineId) {
        this.orderlineId = orderlineId;
    }

    public OrderVO getOrdersVO() {
        return orderVO;
    }

    public void setOrdersVO(OrderVO orderVO) {
        this.orderVO = orderVO;
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
