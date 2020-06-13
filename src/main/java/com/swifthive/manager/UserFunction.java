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
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.repository.UserFunctionRepository;
import com.swifthive.model.userfunction.CreateUserFunctionRequest;

@Service
@Transactional
public class UserFunction {

	private static final Logger logger = Logger.getLogger(UserFunction.class);

	private UserFunctionObject userFunctionObject;
	private Iterable<UserFunctionObject> iUserFunctionObject;

	@Autowired
	UserFunctionRepository userFunctionRepository;

	@Autowired
	Response response;

	@Autowired
	Environment env;

	@Autowired
	PlatformTransactionManager transactionManager;

	DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();

	public Response processCreateUserFunction(@Valid CreateUserFunctionRequest createUserFunctionRequest) {

		TransactionStatus status = null;

		try {
			// execute your business logic here
			defaultTransactionDefinition.setName("transaction");
			defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(defaultTransactionDefinition);

			// persist function information
			userFunctionObject = new UserFunctionObject();
			userFunctionObject.setClientId(createUserFunctionRequest.getClientId());
			userFunctionObject.setFunctionName(createUserFunctionRequest.getFunctionName());
			userFunctionObject.setCreatedBy(createUserFunctionRequest.getUserId());
			userFunctionObject.setStatus("0");
			userFunctionObject.setDateCreated(LocalDateTime.now());
			userFunctionRepository.save(userFunctionObject);
			transactionManager.commit(status);
			response.setUniqueId(userFunctionObject.getUniqueId());
			response.setClientId(createUserFunctionRequest.getClientId());
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
				response.setClientId(createUserFunctionRequest.getClientId());
				response.setResponseCode("007");
				response.setResponseMessage(env.getProperty("007"));
			} else {
				response.setUniqueId(null);
				response.setClientId(createUserFunctionRequest.getClientId());
				response.setResponseCode("099");
				response.setResponseMessage(env.getProperty("099"));
			}
		}

		return response;
	}

	@Transactional
	public Iterable<UserFunctionObject> processListUserFunction() {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = userFunctionRepository.findAll();
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}
		return iUserFunctionObject;
	}

	public Iterable<UserFunctionObject> processListUserFunctionAPL(String status) {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = userFunctionRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}

		return iUserFunctionObject;
	}
}
