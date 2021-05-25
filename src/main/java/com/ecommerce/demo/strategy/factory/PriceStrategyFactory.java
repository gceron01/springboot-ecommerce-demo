package com.ecommerce.demo.strategy.factory;

import com.ecommerce.demo.strategy.impl.PriceDatabaseStrategy;
import com.ecommerce.demo.strategy.impl.PriceFileStrategy;
import com.ecommerce.demo.strategy.PriceStrategy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
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
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            //load a properties file from class path, inside static method
            prop.load(input);
        }catch (IOException ioe){
            ioe.getStackTrace();
        }
        return prop.getProperty(property);
      }
}
