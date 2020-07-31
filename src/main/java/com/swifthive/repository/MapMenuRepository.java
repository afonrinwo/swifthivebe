package com.swifthive.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.menu.MapMenuObject;

@Repository
@EnableTransactionManagement
@Transactional
public interface MapMenuRepository extends CrudRepository<MapMenuObject, Serializable> {

	Iterable<MapMenuObject> findByStatus(int i);

	MapMenuObject findByUniqueId(Long uniqueId);

	MapMenuObject findByMerchantIdAndRoleName(String merchantId, String roleName);

	MapMenuObject findByMerchantIdAndFunctionNameAndRoleName(String merchantId, String functionName, String roleName);

	boolean existsByMerchantIdAndFunctionNameAndRoleName(String merchantId, String functionName, String roleName);

	Iterable<MapMenuObject> findByMerchantId(String merchantId);

	Iterable<MapMenuObject> findByMerchantIdAndStatus(String merchantId, int status);

}
