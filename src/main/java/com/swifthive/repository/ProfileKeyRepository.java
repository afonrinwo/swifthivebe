/**
 * 
 */
package com.swifthive.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swifthive.model.profile.ProfileKeyObject;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Repository
@EnableTransactionManagement
public interface ProfileKeyRepository extends CrudRepository<ProfileKeyObject, Serializable> {

	ProfileKeyObject findByMerchantIdAndUserName(String merchantId, String userName);


}
