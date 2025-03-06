/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.repository.impl;

import com.cnatro.pojo.OrderDetail;
import com.cnatro.pojo.Product;
import com.cnatro.pojo.SaleOrder;
import com.cnatro.saleapp.HibernateUtils;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsResponsitoryImpl {
    
    public List<Object[]> statsRevenueByProduct(){
        
        try( Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root root = q.from(OrderDetail.class);
            
            Join<OrderDetail,Product> join = root.join("productId",JoinType.RIGHT); // orderdetail join voiws product qua productId 
            
            q.multiselect(join.get("id"),join.get("name"),b.sum(b.prod(root.get("unitPrice"),root.get("quantity")))); // tinh tong tich cua quantity và unitPirce
            q.groupBy(join.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
    public List<Object[]> statsRevenueByTime(String time){
        
        try( Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root root = q.from(OrderDetail.class);
            
//            Join<OrderDetail,SaleOrder> joinByDate()
            
            Join<OrderDetail,Product> join = root.join("productId",JoinType.RIGHT); // orderdetail join voiws product qua productId 
            
            q.multiselect(join.get("id"),join.get("name"),b.sum(b.prod(root.get("unitPrice"),root.get("quantity")))); // tinh tong tich cua quantity và unitPirce
            q.groupBy(join.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
}
