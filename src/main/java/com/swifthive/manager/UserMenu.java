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
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.swifthive.model.Response;
import com.swifthive.model.usermenu.CreateUserMenuRequest;
import com.swifthive.model.usermenu.UserMenuMappingRequest;
import com.swifthive.model.usermenu.UserMenuMappingObject;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.repository.UserMenuMappingRepository;
import com.swifthive.repository.UserMenuRepository;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Service
@Transactional
public class UserMenu {

	private static final Logger logger = Logger.getLogger(UserFunction.class);

	private UserMenuObject userMenuObject;
	private UserMenuMappingObject userMenuMappingObject;
	private Iterable<UserMenuObject> iUserMenuObject;
	private Iterable<UserMenuMappingObject> iUserMenuMappingObject;

	@Autowired
	UserMenuRepository userMenuRepository;
	
	@Autowired
	UserMenuMappingRepository userMenuMappingRepository;

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
			userMenuObject.setStatus("0");
			userMenuRepository.save(userMenuObject);
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
			iUserMenuObject = userMenuRepository.findAll();
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}
		return iUserMenuObject;
	}

	public Response processMenuMapping(@Valid UserMenuMappingRequest userMenuMappingRequest) {
		TransactionStatus status = null;
		try {
			// execute your business logic here
			defaultTransactionDefinition.setName("transaction");
			defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(defaultTransactionDefinition);

			// persist function information
			userMenuMappingObject = new UserMenuMappingObject();
			userMenuMappingObject.setClientId(userMenuMappingRequest.getClientId());
			userMenuMappingObject.setFunctionName(userMenuMappingRequest.getFunctionName());
			userMenuMappingObject.setRoleName(userMenuMappingRequest.getRoleName());
			userMenuMappingObject.setSelectedMenuList(userMenuMappingRequest.getSelectedMenuList());
			userMenuMappingObject.setCreatedBy(userMenuMappingRequest.getUserId());
			userMenuMappingObject.setDateCreated(LocalDateTime.now());
			userMenuMappingObject.setStatus("0");
			userMenuMappingRepository.save(userMenuMappingObject);
			transactionManager.commit(status);
			response.setUniqueId(userMenuMappingObject.getUniqueId());
			response.setClientId(userMenuMappingRequest.getClientId());
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
				response.setClientId(userMenuMappingRequest.getClientId());
				response.setResponseCode("007");
				response.setResponseMessage(env.getProperty("007"));
			} else {
				response.setUniqueId(null);
				response.setClientId(userMenuMappingRequest.getClientId());
				response.setResponseCode("099");
				response.setResponseMessage(env.getProperty("099"));
			}
		}
		
		return response;
	}

	public Iterable<UserMenuObject> processListUserMenuAPL(String status) {
		try {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject = userMenuRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}

		return iUserMenuObject;
	}	
	
	public Iterable<UserMenuMappingObject> processMenuMappingAPL(String status) {
		try {
			iUserMenuMappingObject = new ArrayList<>();
			iUserMenuMappingObject = userMenuMappingRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserMenuMappingObject = new ArrayList<>();
			iUserMenuMappingObject.forEach(null);
		}

		return iUserMenuMappingObject;
	}


}
