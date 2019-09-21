package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private   int idPurchase;
    private String nameCustomer;
@OneToMany(fetch = FetchType.EAGER)
@JoinColumn(name = "product_ID")
  private List<Product> products;
    private LocalDateTime buying;
    private LocalDateTime getting;
    private int numberOfBuyingProduct;
    private String phoneCustomer;

    public Purchase() {
    }

    public Purchase(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getBuying() {
        return buying;
    }

    public void setBuying(LocalDateTime buying) {
        this.buying = buying;
    }

    public LocalDateTime getGetting() {
        return getting;
    }

    public void setGetting(LocalDateTime getting) {
        this.getting = getting;
    }

    public int getNumberOfBuyingProduct() {
        return numberOfBuyingProduct;
    }

    public void setNumberOfBuyingProduct(int numberOfBuyingProduct) {
        this.numberOfBuyingProduct = numberOfBuyingProduct;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }
}
