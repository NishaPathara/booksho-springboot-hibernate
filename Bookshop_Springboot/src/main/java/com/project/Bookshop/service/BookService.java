package com.project.Bookshop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Bookshop.entity.Book;
import com.project.Bookshop.entity.User;
import com.project.Bookshop.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired
	BookRepository repository;

	public List<Book> getAllBooks() {
     return repository.findAll();

	}
	public void saveBook(Book book) {

		repository.save(book);
	}
	public Book getBooksByBookid(String bookid){
	     return  repository.getReferenceById(bookid);

		}
	public List<Book> getBooksByAuthor(String author){
	     return repository.findByAuthor(author);

		}
	public List<Book> getBooksByTitle(String title){
	     return repository.findByTitle(title);

		}
	
	public List<Book> getBooksByPublication(String publication) {
		// TODO Auto-generated method stub
		 return repository.findByPublication(publication);
	}
	public void deletebook(String bookid) {
		// TODO Auto-generated method stub
		repository.deleteById(bookid);
		
	}
	

}
