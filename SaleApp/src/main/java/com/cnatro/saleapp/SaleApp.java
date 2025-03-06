/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cnatro.saleapp;

import com.cnatro.repository.impl.CategoryRepositoryImpl;
import com.cnatro.repository.impl.ProductRepositoryImpl;
import com.cnatro.repository.impl.StatsResponsitoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class SaleApp {

    public static void main(String[] args) {
//        CategoryRepositoryImpl cates = new CategoryRepositoryImpl();
//        cates.getCategories().forEach(c -> System.out.println(c.getName()));

//        ProductRepositoryImpl prods = new ProductRepositoryImpl();
//        Map<String,String> ts = new HashMap<>();
//        ts.put("name","iphone");
//        ts.put("fromPrice","300000");
//        ts.put("page", "2");
//        prods.getProducts(ts).forEach( p -> System.out.printf("%d - %s - %.1f \n",p.getId(),p.getName(),(double)p.getPrice()));
          StatsResponsitoryImpl s = new StatsResponsitoryImpl();
          s.statsRevenueByProduct().forEach(tmp -> System.out.printf("%d - %s - %d \n",tmp[0],tmp[1],tmp[2]));
    }
}
