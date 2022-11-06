package com.mobile.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
