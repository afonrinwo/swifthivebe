/**
 * 
 */
package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.swifthive.model.Response;
import com.swifthive.model.usermenu.CreateUserMenuRequest;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.repository.UserMenuRepository;

/**
 * @author emmanuel.afonrinwo
 *
 */
public class UserMenu {

	private static final Logger logger = Logger.getLogger(UserFunction.class);

	UserMenuObject userMenuObject;
	private Iterable<UserMenuObject> iUserMenuObject;

	@Autowired
	UserMenuRepository sqlRepository;

	@Autowired
	Response response;

	@Autowired
	Environment env;

	@Autowired
	PlatformTransactionManager transactionManager;

	DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();

	@Transactional
	public Response processCreateMenu(@Valid CreateUserMenuRequest createUserMenuRequest) {

		TransactionStatus status = null;

		try {
			// execute your business logic here
			defaultTransactionDefinition.setName("transaction");
			defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(defaultTransactionDefinition);

			// persist function information
			userMenuObject = new UserMenuObject();
			userMenuObject.setClientId(createUserMenuRequest.getClientId());
			userMenuObject.setMenuName(createUserMenuRequest.getMenuName());
			userMenuObject.setCreatedBy(createUserMenuRequest.getUserId());
			userMenuObject.setDateCreated(LocalDateTime.now());
			sqlRepository.save(userMenuObject);
			transactionManager.commit(status);
			response.setUniqueId(userMenuObject.getUniqueId());
			response.setClientId(createUserMenuRequest.getClientId());
			response.setResponseCode("00");
			response.setResponseMessage("Successful");

		} catch (Exception ex) {

			try {
				transactionManager.rollback(status);
			} catch (Exception e) {
				logger.error(e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(e));
			}

			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(ex));

			if (ex instanceof DataIntegrityViolationException) {
				response.setUniqueId(null);
				response.setClientId(createUserMenuRequest.getClientId());
				response.setResponseCode("007");
				response.setResponseMessage(env.getProperty("007"));
			} else {
				response.setUniqueId(null);
				response.setClientId(createUserMenuRequest.getClientId());
				response.setResponseCode("099");
				response.setResponseMessage(env.getProperty("099"));
			}
		}

		return response;
	}

	public Iterable<UserMenuObject> processListUserMenu() {
		try {
			iUserMenuObject = sqlRepository.findAll();
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}
		return iUserMenuObject;
	}
}
