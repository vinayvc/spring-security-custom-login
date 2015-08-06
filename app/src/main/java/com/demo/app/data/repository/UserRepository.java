/**
 * 
 */
package com.demo.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.app.data.model.User;

/**
 * @author vinay
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	
}
