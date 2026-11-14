/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.java.project.dao.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.java.project.TestDataUtil;
import com.java.project.domain.Book;


/**
 *
 * @author ananya
 */

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(
            eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
            eq("1"),
            eq("The Shadow in the Attic"),
            eq(1L)
        );
    }

    @Test 
    public void testThatFindOneBookGeneratesCorrectSql(){
        underTest.findOne("1");
        verify(jdbcTemplate).query(
            eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
            ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
            eq("1")
        );

    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
            eq("SELECT isbn, title, author_id FROM books"),
            ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("5", book);
        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "1", "The Shadow", 1L, "5"
        );
    }

    @Test 
    public void testThatDeleteGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.delete(book.getIsbn());
        verify(jdbcTemplate).update(
            "DELETE FROM books where isbn = ?",
            "1"
        );
    }

}
