/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class StatsServce {

    public List<Object> stats_question_choice() throws SQLException {
        List<Object> stats = new ArrayList<>();
        try (Connection conn = jdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{call statis_product_choice()}");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Object[] t = {rs.getString("id"), rs.getString("content"), rs.getInt("quantity")};
                stats.add(t);
            }
        }
        return stats;
    }

    //    public int count_question_cate(String categoryName) throws SQLException{
//        Connection conn = jdbcUtils.getConn();
//        CallableStatement stm = conn.prepareCall("{Call stats_question_by_cat(?,?)}");
//        stm.setString(1, categoryName);
//        
//        
//    }
}
