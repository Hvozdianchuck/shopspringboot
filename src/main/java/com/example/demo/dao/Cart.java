package com.example.demo.dao;

import com.example.demo.model.Smartphone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Cart {
    private List<Smartphone> products = new ArrayList<>();


    public  void addProduct(Smartphone smartphone){
        products.add(smartphone);
    }

    public   List<Smartphone>  getProducts() {
        return products;
    }
 public void clearCart(){
        products.clear();
 }
}
