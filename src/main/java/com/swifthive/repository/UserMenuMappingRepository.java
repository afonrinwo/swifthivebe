package com.swifthive.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.usermenu.UserMenuMappingObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface UserMenuMappingRepository extends CrudRepository<UserMenuMappingObject, Serializable> {

	Iterable<UserMenuMappingObject> findByStatus(String status);

	boolean existsByIds(String functionName, String roleName);

		
}
