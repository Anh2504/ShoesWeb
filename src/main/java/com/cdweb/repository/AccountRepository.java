package com.cdweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	Account findById(int id);
	Account findByEmail(String email);
	Account findByPhone(long phone);
	Account findByName(String name);
	Account findByPassword(String password);
	ArrayList<Account> findAll();
}
