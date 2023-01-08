package com.project.Bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Bookshop.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	List<Book> findByPublication(String publication);

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);


}