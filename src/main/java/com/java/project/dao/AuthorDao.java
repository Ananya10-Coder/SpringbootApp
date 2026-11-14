/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.java.project.dao;

import java.util.List;
import java.util.Optional;

import com.java.project.domain.Author;

/**
 *
 * @author ananya
 */
public interface AuthorDao {
    
    void create(Author author);
    Optional<Author> findOne(long l);
    List<Author> find();
    void update(long id, Author author);
    void delete(long id);



}
