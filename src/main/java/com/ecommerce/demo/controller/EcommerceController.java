package com.ecommerce.demo.controller;

import com.ecommerce.demo.facade.EcommerceFacade;
import com.ecommerce.demo.model.Order;
import com.ecommerce.demo.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EcommerceController {

    @Resource
    private EcommerceFacade ecommerceFacade;

    @GetMapping("/")
    public String getHomepage(Model model) {
        clearOrder();
        return "homepage"; //view
    }

    @Resource
    private Order order;

    private int orderIdCounter = 1;

    @GetMapping("/productlist")
    public String getProductList(Model model) {
        List<Product> productList =ecommerceFacade.getProductList();
        model.addAttribute("productList", productList);
        model.addAttribute("order", order);
        return "productlist"; //view
    }

    @GetMapping("/addtocart")
    public String addtoCart(
            @RequestParam(name = "id", required = false, defaultValue = "0") String name, Model model) {
        List<Product> productList =ecommerceFacade.getProductList();
        Product product = ecommerceFacade.getProductbyID(new Long(name));
        order.getProducts().add(product);
        double totalOrdervalue = ecommerceFacade.calculateTotalOrderValue(order.getProducts());
        order.setTotalValue(totalOrdervalue);
        model.addAttribute("productList", productList);
        model.addAttribute("order", order);

        return "productlist"; //view
    }

    @GetMapping("/orderconfirmation")
    public String confirmOrder(Model model) {
        model.addAttribute("order", order);
        return "orderconfirmation"; //view
    }

    private void clearOrder(){
        order = new Order();
        order.setId(orderIdCounter++);
    }
}