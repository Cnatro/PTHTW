/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.services.Impl;

import com.cnatro.pojo.Product;
import com.cnatro.repositories.ProductRepository;
import com.cnatro.services.ProductServices;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductRepository proRepo;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.proRepo.getProducts(params);
    }

    @Override
    public Product getProductById(int id) {
        return this.proRepo.getProductById(id);
    }

    @Override
    public Product addOrUpdateProduct(Product p) {
        return this.proRepo.addOrUpdateProduct(p);
    }

    @Override
    public void deleleProduct(int id) {
        this.proRepo.deleleProduct(id);
    }

}
