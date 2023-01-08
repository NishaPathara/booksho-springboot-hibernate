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
import com.project.Bookshop.service.UserService;

@Controller
public class UserController {

	public UserController() {
		System.out.println("inside UserController contr...");
	}

	@Autowired
	UserService service;

	@GetMapping("/registrationPage")
	public String registrationPage() {
		System.out.println("inside first register() ");
		return "registration_page";
	}

	@PostMapping("/register")
	public String register(String username, String password, String name, String email, String usertype) {

		System.out.println("inside register() " + username + ", " + password + ", " + name + ", " + email);
		User user = new User("nisha", "nisha", "nisha", "nygmail", "user", null, null);
		Book book1 = new Book("fdgdf", "dfsdf", "dfsdf", "dsfg", user);
		List<Book> favbook = new ArrayList<Book>();
		favbook.add(book1);
		List<Book> readltrbook = new ArrayList<Book>();
		readltrbook.add(book1);
		user.setFav_books(readltrbook);
		user.setRead_ltr(readltrbook);
		// User user = new User(username, password, name, email, usertype,null,null);
		// User user = new User("nisha", "nisha", "nisha", "nygmail",
		// "user",favbook,readltrbook);
		User user1 = new User("rev", "rev", "revin", "rngmail", "admn", favbook, readltrbook);
		// user.setFav_books(null);
		// user.setRead_ltr(null);

		service.saveUser(user);
		service.saveUser(user1);

		return "index";
	}

	@PostMapping("/login")
	public ModelAndView login(String uname, String pwd) {

		System.out.println("inside login() " + uname + ", " + pwd);

		User user = service.validate(uname);

		if (user != null) {
			System.out.println("user not null");

			ModelAndView modelAndView = null;
			if (user.getUsertype().equalsIgnoreCase("user")) {
				System.out.println("user type");
				modelAndView = new ModelAndView("user_welcome");
				modelAndView.addObject("userData", user);

			} else if (user.getUsertype().equalsIgnoreCase("admn")) {
				System.out.println("user not null");
				modelAndView = new ModelAndView("admin_welcome");
				modelAndView.addObject("userData", user);

			}
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("error");
			return modelAndView;
		}
	}

}
