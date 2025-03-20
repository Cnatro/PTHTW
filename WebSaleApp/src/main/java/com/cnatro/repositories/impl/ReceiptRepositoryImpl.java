///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.cnatro.repositories.impl;
//
//import com.cnatro.pojo.Cart;
//import com.cnatro.pojo.OrderDetail;
//import com.cnatro.pojo.SaleOrder;
//import java.util.Date;
//import java.util.Map;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class ReceiptRepositoryImpl {
//    public void addReceipt(Map<String, Cart> carts) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            SaleOrder r = new SaleOrder();
//            r.setCreatedDate(new Date());
//            r.setUserId(new UserRepositoryImpl().getUserByUsername("dhthanh"));
//            s.persist(r);
//            
//            for (var c: carts.values()) {
//                OrderDetail d = new OrderDetail();
//                d.setQuantity(c.getQuantity());
//                d.setUnitPrice(c.getPrice());
//                d.setOrderId(r);
//                d.setProductId(new ProductRepositoryImpl().getProductById(c.getId()));
//                
//                s.persist(d);
//            }
//        }
//    }
//}
