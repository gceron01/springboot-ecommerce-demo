package com.ecommerce.demo.strategy.factory;

import com.ecommerce.demo.strategy.impl.PriceDatabaseStrategy;
import com.ecommerce.demo.strategy.impl.PriceFileStrategy;
import com.ecommerce.demo.strategy.PriceStrategy;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Component
public class PriceStrategyFactory {

    public PriceStrategy getPriceStragey(){
        if(getProperty("price.strategy").equals("database")){
            return new PriceDatabaseStrategy();
        }else{
            return new PriceFileStrategy();
        }
    }

    private String getProperty(String property){
        Properties p=new Properties();
        try {
            FileReader reader=new FileReader("c:\\Users\\gmcr0\\Documents\\springboot-ecommerce-demo\\src\\main\\resources\\application.properties");
            p.load(reader);
        }catch (IOException ioe){
            ioe.getStackTrace();
        }
        return p.getProperty(property);
      }
}
