package com.example.servletpbi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByFullNameIgnoreCaseContainingOrEmailIgnoreCaseContaining(String name, String email);

}
