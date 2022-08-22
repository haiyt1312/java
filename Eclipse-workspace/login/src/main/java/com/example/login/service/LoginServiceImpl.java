/**
 * 
 */
package com.example.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.Account;
import com.example.login.repository.LoginRepository;

/**
 * @author Admin
 *
 */
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository loginRepository;

	public Optional<Account> findById(String id) {
		return loginRepository.findById(id);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		Optional<Account> optionalAccount = findById(username);
		if (optionalAccount.isPresent()&&optionalAccount.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
}
