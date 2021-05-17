package com.ecommerce.demo.strategy.impl;

import com.ecommerce.demo.service.DatabaseService;
import com.ecommerce.demo.service.FileService;
import com.ecommerce.demo.strategy.PriceStrategy;

public class PriceDatabaseStrategy implements PriceStrategy {

    DatabaseService databaseService;

    @Override
    public double getPriceforProduct(long productId) {
        databaseService = new DatabaseService();
        double price = databaseService.getPriceByProductID(productId);
        return price;
    }
}
