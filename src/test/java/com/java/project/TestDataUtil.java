package com.java.project;

import com.java.project.domain.Author;
import  com.java.project.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
        
    }

    public static Author createTestAuthorA(){
        return Author.builder()
            .id(1L)
            .name("Abigail")
            .age(28)
            .build();
    }
    public static Author createTestAuthorB(){
        return Author.builder()
            .id(2L)
            .name("Rose")
            .age(80)
            .build();
    }
    public static Author createTestAuthorC(){
        return Author.builder()
            .id(3L)
            .name("Tom")
            .age(34)
            .build();
    }

    public static Book createTestBookA(){
        return Book.builder()
            .isbn("1")
            .title("The Shadow")
            .authorId(1L)
            .build();
    }

    public static Book createTestBookB(){
        return Book.builder()
            .isbn("2")
            .title("In the Attic")
            .authorId(2L)
            .build();
    }

    public static Book createTestBookC(){
        return Book.builder()
            .isbn("3")
            .title("Harry Potter")
            .authorId(3L)
            .build();
    }
}