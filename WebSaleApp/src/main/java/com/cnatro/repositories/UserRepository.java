/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cnatro.repositories;


import com.cnatro.pojo.User;

/**
 *
 * @author admin
 */
public interface UserRepository {
    User getUserByUsername(String username);
    User addUser(User u);
}