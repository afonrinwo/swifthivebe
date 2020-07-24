package com.swifthive.repository;

import java.io.Serializable;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.menu.MenuObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface MenuRepository extends CrudRepository<MenuObject, Serializable> {
	
	Iterable<MenuObject> findAll();

	Iterable<MenuObject> findByStatus(int i);

	boolean existsByMenuName(String menuName);

	MenuObject findByUniqueId(Long uniqueId);

	Iterable<MenuObject> findAllByUniqueIdIn(long[] lIds);
	
}
