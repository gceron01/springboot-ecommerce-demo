package com.ecommerce.demo.service;

import com.ecommerce.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseService {

    List<Product> productList = new ArrayList<>();

    {
        Product p1 = new Product(1, "Product1", "Description 1");
        Product p2 = new Product(2, "Product2", "Description 2");
        Product p3 = new Product(3, "Product3", "Description 3");
        Product p4 = new Product(4, "Product4", "Description 4");
        Product p5 = new Product(5, "Product5", "Description 5");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
    }

    public List<Product> getProductList() {

        return productList;
    }

    public Product getProductByID(long productID) {
        return productList.get((int)productID-1);
    }

    public double getPriceByProductID(long productID){
        // TODO
        return 100;
    }
}
