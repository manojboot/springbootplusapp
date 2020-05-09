package com.test.springplus.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.springplus.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.username = :name")
	public User searchByUsername(@Param("name")String name);
}
