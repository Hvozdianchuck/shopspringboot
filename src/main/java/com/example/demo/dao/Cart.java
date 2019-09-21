package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.model.Smartphone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Cart {
    private List<Product> products = new ArrayList<>();

//    private List<Integer> products = new ArrayList<>();

    public  void addProduct(Product product){
        products.add(product);
    }

    public   List<Product>  getProducts() {
        return products ;
    }
 public void clearCart(){
        products.clear();
 }

    public void removeProduct(Integer id ){
products.removeIf(x->x.getId()==id);

        products.forEach(x-> System.out.println(x.getName()));
    }
    public long getPrice(){
        return products.stream().map(x->x.getPrice()).count();
    }
public Double addition(){
       return products.stream().mapToDouble(x->x.getPrice()).sum();
}
}
