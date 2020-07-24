package com.swifthive.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.function.*;

@Repository
@EnableTransactionManagement
public interface FunctionRepository extends CrudRepository<FunctionObject, Serializable> {
	
	Iterable<FunctionObject> findAll();

	Iterable<FunctionObject> findByStatus(int status);

	boolean existsByFunctionName(String functionName);

	FunctionObject findByUniqueId(Long uniqueId);

}
