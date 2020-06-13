package com.swifthive.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.ClientErrorLogObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface ClientErrorLogRepository extends CrudRepository<ClientErrorLogObject, Serializable> {
		
}
