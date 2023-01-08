package com.project.Bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Bookshop.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>{

	
	//User findByUsernameAndPassword(String username, String password);

}