package com.swifthive.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.userfunction.*;

@Repository
@EnableTransactionManagement
public interface UserFunctionRepository extends CrudRepository<UserFunctionObject, Serializable> {
	
	Iterable<UserFunctionObject> findAll();

	Iterable<UserFunctionObject> findByStatus(String status);

	boolean existsByFunctionName(String functionName);

	UserFunctionObject findByUniqueId(Long uniqueId);

}
