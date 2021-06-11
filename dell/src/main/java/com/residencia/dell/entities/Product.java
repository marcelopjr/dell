package com.residencia.dell.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long prodId;

    @Column(name = "category")
    private Long category;

    @Column(name = "title")
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "special")
    private Integer special;

    @Column(name = "common_pro_id")
    private Long commonProdId;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    } 

    public Long getCommonProdId() {
        return commonProdId;
    }

    public void setCommonProdId(Long commonProdId) {
        this.commonProdId = commonProdId;
    }
}
