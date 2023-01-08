package com.project.Bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication(scanBasePackages={
//"com.project.controller", "com.project.service", "com.project.repository", "com.project.entity"})
//@ComponentScan("com.project.repository")
//@ComponentScan("com.project")
@SpringBootApplication
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
