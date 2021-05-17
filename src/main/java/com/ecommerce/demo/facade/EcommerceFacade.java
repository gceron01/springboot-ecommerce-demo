package com.ecommerce.demo.facade;

import com.ecommerce.demo.model.Product;
import com.ecommerce.demo.service.DatabaseService;
import com.ecommerce.demo.strategy.PriceStrategy;
import com.ecommerce.demo.strategy.factory.PriceStrategyFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class EcommerceFacade {

    @Resource
    private DatabaseService databaseService;

    @Resource
    PriceStrategyFactory priceStrategyFactory;

    PriceStrategy priceStrategy;


    public List<Product> getProductList(){
        List<Product> productList = databaseService.getProductList();
        priceStrategy = priceStrategyFactory.getPriceStragey();
        for (Product p: productList) {
            p.setPrice(priceStrategy.getPriceforProduct(p.getId()));
        }
        return productList;
    }

    public Product getProductbyID(long productID){
        Product product = databaseService.getProductByID(productID);
        priceStrategy = priceStrategyFactory.getPriceStragey();
        product.setPrice(priceStrategy.getPriceforProduct(product.getId()));
        return product;
    }

    public double calculateTotalOrderValue(List<Product> productList){
        double totalOrderValue = 0.0;
        for (Product p : productList) {
            totalOrderValue += p.getPrice();
        }
        return totalOrderValue;
    }
}
