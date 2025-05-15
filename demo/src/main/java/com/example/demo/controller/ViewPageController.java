package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;


@Controller
public class ViewPageController {

 

        @GetMapping("/products_page")
    public String product_page(Model model) {
        model.addAttribute("Product", new Product()); // <-- important line
        return "products";
    }

    
        @GetMapping("/regForm")
    public String regform_page(Model model) {
        model.addAttribute("user", new User()); // <-- important line
        return "regForm";
    }

}
