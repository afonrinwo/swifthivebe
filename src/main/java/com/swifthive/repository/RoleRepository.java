package com.swifthive.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.role.RoleObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface RoleRepository extends CrudRepository<RoleObject, Serializable> {
	
	Iterable<RoleObject> findAll();

	Iterable<RoleObject> findByStatus(int i);

	boolean existsByRoleName(String roleName);

	RoleObject findByUniqueId(Long uniqueId);
	
}
