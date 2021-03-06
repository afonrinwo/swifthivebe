/**
 * 
 */
package com.swifthive.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.profile.ProfileObject;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Repository
@EnableTransactionManagement
public interface ProfileRepository extends CrudRepository<ProfileObject, Serializable> {

	boolean existsByUserName(String userName);

	Iterable<ProfileObject> findByStatus(int i);

	ProfileObject findByUniqueId(Long uniqueId);

	ProfileObject findByMerchantIdAndUserName(String merchantId, String userName);

	ProfileObject findByUserName(String createdBy);

	Iterable<ProfileObject> findByMerchantId(String merchantId);

	Iterable<ProfileObject> findByMerchantIdAndStatus(String merchantId, int status);

}
