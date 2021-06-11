package com.residencia.dell.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cust_hist")
public class CustHist{


    /*@Id
    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "custumerId")
    private Long customerId;//estrangeira de customer*/

    @Id
    @Column(name = "customerid")
    private Long customerId;//estrangeira de customer

    @Column(name = "orderid")
    private Long orderId;

    @Column(name = "prod_id")
    private Long prodId;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }
}
