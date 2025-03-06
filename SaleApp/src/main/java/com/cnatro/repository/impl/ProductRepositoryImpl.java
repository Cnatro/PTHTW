/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.repository.impl;

import com.cnatro.pojo.Product;
import com.cnatro.saleapp.HibernateUtils;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {

    private static final int PAGE_SIZE = 6;

    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            // các value root.get lấy từ các thuộc tính trong Product
            q.select(root);

            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();

                String kw = params.get("kw");

                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
                }

                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"),
                            Double.parseDouble(fromPrice)));
                }

                String toPrice = params.get("toPrice");
                if (toPrice != null && !toPrice.isEmpty()) {
                    predicates.add(b.lessThan(root.get("price"), Double.parseDouble(toPrice)));
                }

                String cateId = params.get("cateId");
                if (cateId != null && !cateId.isEmpty()) {
                    predicates.add(b.equal(root.get("categoryId").as(Integer.class),
                            Integer.parseInt(cateId)));
                }

                q.where(predicates.toArray(Predicate[]::new));
            }
            Query query = s.createQuery(q);

            if (params != null) {
                int page = Integer.parseInt(params.getOrDefault("page", "1"));
                int start = (page - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE); // limit

            }
            return query.getResultList();
        }
    }
}
