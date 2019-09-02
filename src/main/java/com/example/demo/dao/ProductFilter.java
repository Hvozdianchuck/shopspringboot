package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Component
public class ProductFilter  {
    private List<Smartphone> productsList;


    public List<Smartphone> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Smartphone> productsList) {
        this.productsList = productsList;
    }

    public List<Smartphone> getProductsIntoFilter(List<Smartphone> products){
     productsList.retainAll(products);
     return products;
 }


}
