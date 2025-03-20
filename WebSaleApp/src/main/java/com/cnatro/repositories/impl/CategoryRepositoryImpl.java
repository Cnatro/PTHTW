/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.repositories.impl;

import com.cnatro.pojo.Category;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.cnatro.repositories.CategoryRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Category> getCategories() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createNamedQuery("Category.findAll", Category.class);
        return q.getResultList();
    }

}
