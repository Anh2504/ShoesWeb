package com.cdweb.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.model.Account;
import com.cdweb.repository.AccountRepository;

@Service("accountservice")
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Transactional
	public void addAccount(Account account) {
		Account accToAdd = new Account();
		accToAdd.setEmail(account.getEmail());
		accToAdd.setName(account.getName());
		accToAdd.setPassword(account.getPassword());
		accToAdd.setPhone(account.getPhone());
		accToAdd.setAddress(account.getAddress());
		accountRepository.save(accToAdd);
	}
	
	
	@Transactional
	public boolean checkLogin(String email, String password) {
		Account account = accountRepository.findByEmail(email);
		if(account == null) {
			return false;
		}else {
			//String checkEmail = account.getEmail();
			String checkPassword = account.getPassword();
			if(!checkPassword.equalsIgnoreCase(password)) {
				return false;
			}
			return true;
		}
		
	}
	
	@Transactional
	public ArrayList<Account> findAll(){
		return accountRepository.findAll();
	}
	@Transactional
	public Account find(int id) {
		return accountRepository.findById(id);
	}
	
	@Transactional
	public Account findByName(String name) {
		return accountRepository.findByName(name);
	}
}
