/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.repository.impl;

import com.cnatro.pojo.Category;
import com.cnatro.saleapp.HibernateUtils;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {

    public List<Category> getCategories() {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            Query q = s.createQuery("FROM Category", Category.class); // Category tên của class chứ k phải bảng trong database
            return q.getResultList();
        }
    }
}
