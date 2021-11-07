package com.example.bloodpressureapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Userrepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

	List<User> findByRole(String role);
}
