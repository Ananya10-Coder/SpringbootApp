/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.java.project.dao;

import java.util.List;
import java.util.Optional;

import com.java.project.domain.Book;

/**
 *
 * @author ananya
 */
public interface BookDao {
    void create(Book book);
    Optional<Book> findOne(String isbn);
    List<Book> find();
    void update(String isbn, Book book);
    void delete(String isbn);
}
