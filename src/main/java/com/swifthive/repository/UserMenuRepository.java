package com.swifthive.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.createMenu.CreateMenuObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface UserMenuRepository extends CrudRepository<CreateMenuObject, Serializable> {
	
	Iterable<CreateMenuObject> findAll();
	
}
