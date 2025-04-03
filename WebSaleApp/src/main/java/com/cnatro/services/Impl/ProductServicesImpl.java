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
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private Cloudinary cloudinary;

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
        if (!p.getFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1710141425/bufd2mlepddhu4mh53ev.png");
        }
        return this.proRepo.addOrUpdateProduct(p);
    }

    @Override
    public void deleleProduct(int id) {
        this.proRepo.deleleProduct(id);
    }

}
