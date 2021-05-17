package com.ecommerce.demo.strategy.impl;


import com.ecommerce.demo.service.FileService;
import com.ecommerce.demo.strategy.PriceStrategy;

public class PriceFileStrategy implements PriceStrategy {

    FileService fileService;

    @Override
    public double getPriceforProduct(long productId) {
        fileService = new FileService();
        double price = fileService.getPriceByProductID(productId);
        return price;
    }
}
