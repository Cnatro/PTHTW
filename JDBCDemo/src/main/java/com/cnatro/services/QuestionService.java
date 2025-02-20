/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.services;

import com.cnatro.pojo.Choice;
import com.cnatro.pojo.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {

    public List<Question> getQuestion(String kw, int num) throws SQLException {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = jdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL get_question_by_kw(?,?)}");
            stm.setString(1, kw);
            stm.setInt(2, num);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                questions.add(q);
            }
        }
        return questions;
    }

    public List<Choice> getChoice(String questionId) throws SQLException {
        List<Choice> choices = new ArrayList<>();
        try (Connection conn = jdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL get_choice_by_question_id(?)}");
            stm.setString(1, questionId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id"));
                choices.add(c);
            }
        }
        return choices;
    }


   
}
