package com.org.repository;

import com.org.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository

public interface UserRepo extends JpaRepository<User, String> {

	@Query (value= "select * from user u where u.username =:username and u.password= :password",nativeQuery = true)
	public User authenticate(@Param("username") String username, @Param("password") String password);	

	@Query (value ="select * from user u where u.username=:username", nativeQuery= true)
	public User findbyusername(@Param("username")String username);
}								


