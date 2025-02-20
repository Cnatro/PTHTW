/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cnatro.jdbcdemo;

import com.cnatro.pojo.Choice;
import com.cnatro.pojo.Question;
import com.cnatro.services.QuestionService;
import com.cnatro.services.StatsServce;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class JDBCDemo {

    public static void main(String[] args) throws SQLException {

        StatsServce ss = new StatsServce();
        List<Object> stats = ss.stats_question_choice();
        for (Object st : stats) {
            Object[] statArray = (Object[]) st;
            System.out.printf("%s - %s - %d \n",statArray[0],statArray[1],statArray[2]);
        }
            
//        QuestionService s = new QuestionService();
//        
//        Scanner sc = new Scanner(System.in);
//        List<Question> questions = s.getQuestion("", 2);
//        for (Question question : questions) {
//            System.out.println(question);
//            
//            List<Choice> choices = s.getChoice(question.getId());
//            
//            for ( int i = 0; i < choices.size(); i++){
//                System.out.printf("%d. %s \n",i+1,choices.get(i));
//            }
//            
//            System.out.print("Your choice : ");
//            int c = sc.nextByte();
//            if ( choices.get(c-1).getCorrect() == true)
//                    System.out.println("EXACTLY");
//            else
//                System.out.println("WRONGLY");
//        }

        }
    }
