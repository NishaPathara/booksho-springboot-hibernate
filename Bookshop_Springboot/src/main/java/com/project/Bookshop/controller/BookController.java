package com.project.Bookshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Bookshop.entity.Book;
import com.project.Bookshop.entity.User;
import com.project.Bookshop.service.BookService;
import com.project.Bookshop.service.UserService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	@Autowired
	UserService userservice;

	@GetMapping("/logout")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/view_books/{username}")
	public ModelAndView getBooks(@PathVariable("username") String usrname) {
		System.out.println("username of loggedin=" + usrname);
		List<Book> books = service.getAllBooks();
		User user = userservice.validate(usrname);
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("book_details");
			modelAndView.addObject("allBooks", books);
			modelAndView.addObject("user", user);
			return modelAndView;
		}

	}

	@GetMapping("/view_books_admn")
	public ModelAndView getBooks_admn() {

		List<Book> books = service.getAllBooks();
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("book_details_admn");

			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/add_book_admn")
	public String addBookpage() {

		return "addbook";
	}

	@PostMapping("/addbook")
	public String addbook(String bookid, String title, String author, String publication) {
		System.out.println("bookdetails" + bookid + author + publication + title);
		Book book = new Book(bookid, title, author, publication);
		// Book book = new Book("book1", "book1", "rev", "gynn");

		service.saveBook(book);

		return "admin_welcome";
	}

	@GetMapping("/Update/{bookid}")
	public String updatebook(String bookid) {
		return "updatebook";
	}

	@PostMapping("/updatebook")
	public String updatebookdetails(String bookid, String title, String author, String publication) {
		System.out.println("bookdetails" + bookid + author + publication + title);
		Book book = new Book(bookid, title, author, publication);
		// Book book = new Book("book1", "book1", "rev", "gynn");
		service.saveBook(book);
		return "admin_welcome";
	}

	/*
	 * @PostMapping("/Update/{bookid}") public String updatebook(String bookid,
	 * String title, String author, String publication) {
	 * System.out.println("updatebookdetails" + bookid + author + publication +
	 * title); Book book = new Book(bookid, title, author, publication); // Book
	 * book = new Book("book1", "book1", "rev", "gynn");
	 * 
	 * service.saveBook(book);
	 * 
	 * return "admin_welcome"; }
	 */

	@GetMapping("/fav/{bookid}/{username}")
	public String addToFav(@PathVariable("username") String usrname, @PathVariable("bookid") String bookid) {
		System.out.println("add to fav" + bookid + "username=" + usrname);

		User user = userservice.validate(usrname);
		Book book_to_add = service.getBooksByBookid(bookid);
		List<Book> fav_books = new ArrayList();
		fav_books.add(book_to_add);
		user.setFav_books(fav_books);
		userservice.saveUser(user);

		return "index";
	}

	@GetMapping("/readlater/{bookid}/{username}")
	public String readlater(@PathVariable("username") String usrname, @PathVariable("bookid") String bookid) {
		System.out.println("add to fav" + bookid + "username=" + usrname);

		User user = userservice.validate(usrname);
		Book book_to_read = service.getBooksByBookid(bookid);
		List<Book> later_books = new ArrayList();
		later_books.add(book_to_read);
		user.setRead_ltr(later_books);
		userservice.saveUser(user);

		return "index";
	}

	@GetMapping("/searchbytitleuser")
	public ModelAndView searchByTitle(String title) {

		List<Book> books = service.getBooksByTitle(title);
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {

			ModelAndView modelAndView = new ModelAndView("book_details");

			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/searchbybookiduser")
	public ModelAndView searchByBookid(String bookid) {
		System.out.println("search book id " + bookid);
		Book book = service.getBooksByBookid(bookid);
		System.out.println("search book name " + book.getTitle());
		if (book.equals(null)) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("book_details");
			List<Book> books = new ArrayList();
			books.add(book);
			modelAndView.addObject("allBooks", books);
			return modelAndView;
		}
	}

	@GetMapping("/searchbyauthoruser")
	public ModelAndView searchByAuthor(String author) {

		List<Book> books = service.getBooksByAuthor(author);
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {

			ModelAndView modelAndView = new ModelAndView("book_details");

			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/searchbypublicationuser")
	public ModelAndView searchByPublication(String publication) {

		List<Book> books = service.getBooksByPublication(publication);
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {

			ModelAndView modelAndView = new ModelAndView("book_details");

			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/searchbybookidadmn")
	public ModelAndView searchByBookid_admn(String bookid) {
		System.out.println("search book id " + bookid);
		Book book = service.getBooksByBookid(bookid);
		System.out.println("search book name " + book.getTitle());
		if (book.equals(null)) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("book_details_admn");
			List<Book> books = new ArrayList();
			books.add(book);
			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/searchbyauthoradmn")
	public ModelAndView searchByAuthor_admn(String author) {

		List<Book> books = service.getBooksByAuthor(author);
		if (books.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("book_not_found");
			return modelAndView;
		} else {

			ModelAndView modelAndView = new ModelAndView("book_details_admn");

			modelAndView.addObject("allBooks", books);

			return modelAndView;
		}
	}

	@GetMapping("/Delete/{bookid}")
	public ModelAndView delete(@PathVariable String bookid) {

		System.out.println("the bookid  to delete is " + bookid);

		service.deletebook(bookid);

		List<Book> books = service.getAllBooks();

		ModelAndView modelAndView = new ModelAndView("book_details_admn");

		modelAndView.addObject("allBooks", books);

		return modelAndView;

	}

}
