/**
 * 
 */
package com.example.demo3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo3.model.User;

/**
 * @author Admin
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT c FROM User c WHERE c.name =:name")
	User findUserByName(String name);
}
