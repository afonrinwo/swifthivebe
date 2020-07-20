/**
 * 
 */
package com.swifthive.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.menu.NavigationParamObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
@EnableTransactionManagement
public interface NavigationParamRepository extends CrudRepository<NavigationParamObject, Serializable> {

	boolean existsByNavItemAndNavIconAndNavText(String navItem, String navIcon, String navText);

	Iterable<NavigationParamObject> findByStatus(String status);

	NavigationParamObject findByUniqueId(Long uniqueId);

}
