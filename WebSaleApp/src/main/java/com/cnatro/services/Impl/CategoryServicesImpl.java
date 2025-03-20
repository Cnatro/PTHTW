/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.services.Impl;

import com.cnatro.pojo.Category;
import com.cnatro.repositories.CategoryRepository;
import com.cnatro.services.CategoryServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryRepository cateRepo;

    @Override
    public List<Category> getCategories() {
        return this.cateRepo.getCategories();
    }
    
}
