/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cnatro.services;

import com.cnatro.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface ProductServices {

    List<Product> getProducts(Map<String, String> params);

    public Product getProductById(int id);

    Product addOrUpdateProduct(Product p);

    void deleleProduct(int id);
}
