/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.controllers;

import com.cnatro.pojo.Product;
import com.cnatro.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {
    @Autowired
    private ProductServices prodSer;
    
    @GetMapping("/products")
    public String manageProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
    
    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product") Product p) {
        this.prodSer.addOrUpdateProduct(p);
        
        return "redirect:/";
    }
    
    @GetMapping("/products/{productId}")
    public String updateView(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.prodSer.getProductById(id));
        
        return "products";
    }
}