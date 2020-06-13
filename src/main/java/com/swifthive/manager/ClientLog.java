package com.swifthive.manager;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.swifthive.model.ClientAuditLogObject;
import com.swifthive.model.ClientErrorLogObject;
import com.swifthive.model.ClientLogRequest;
import com.swifthive.repository.ClientAuditLogRepository;
import com.swifthive.repository.ClientErrorLogRepository;

@Service
@Transactional
public class ClientLog {
	
	private static final Logger logger = Logger.getLogger(UserFunction.class);

	private ClientErrorLogObject clientErrorLogObject;
	private ClientAuditLogObject clientAuditLogObject;

	@Autowired
	ClientErrorLogRepository clientErrorLogRepository;

	@Autowired
	ClientAuditLogRepository clientAuditLogRepository;
	
	@Autowired
	Environment env;

	@Autowired
	PlatformTransactionManager transactionManager;

	DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
	

	public void processClientLog(@Valid ClientLogRequest clientLogRequest) {
		TransactionStatus status = null;
		
		if(clientLogRequest.getLogType().toUpperCase() == "AUDIT") {
			try {
				// execute your business logic here
				defaultTransactionDefinition.setName("transaction");
				defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
				status = transactionManager.getTransaction(defaultTransactionDefinition);

				// persist function information
				clientAuditLogObject = new ClientAuditLogObject();
				clientAuditLogObject.setClientId(clientLogRequest.getClientId());
				clientAuditLogObject.setUserId(clientLogRequest.getUserId());
				clientAuditLogObject.setFuctionCalled(clientLogRequest.getFuctionCalled());
				clientAuditLogObject.setStatus(clientLogRequest.getStatus());
				clientAuditLogObject.setMessage(clientLogRequest.getMessage());
				clientAuditLogObject.setCurrentDateTime(clientLogRequest.getCurrentDateTime());
				clientAuditLogRepository.save(clientAuditLogObject);
				transactionManager.commit(status);

			} catch (Exception ex) {

				try {
					transactionManager.rollback(status);
				} catch (Exception e) {
					logger.error(e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(e) + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getFuctionCalled() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getCurrentDateTime());
				}

				logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(ex) + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getFuctionCalled() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getCurrentDateTime());

			}
		} else {
			
			try {
				// execute your business logic here
				defaultTransactionDefinition.setName("transaction");
				defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
				status = transactionManager.getTransaction(defaultTransactionDefinition);

				// persist audit log function information 
				clientAuditLogObject = new ClientAuditLogObject();
				clientAuditLogObject.setClientId(clientLogRequest.getClientId());
				clientAuditLogObject.setUserId(clientLogRequest.getUserId());
				clientAuditLogObject.setFuctionCalled(clientLogRequest.getFuctionCalled());
				clientAuditLogObject.setStatus(clientLogRequest.getStatus());
				clientAuditLogObject.setMessage(clientLogRequest.getMessage());
				clientAuditLogObject.setCurrentDateTime(clientLogRequest.getCurrentDateTime());
				clientAuditLogRepository.save(clientAuditLogObject);
				
				// persist error log function information 
				clientErrorLogObject = new ClientErrorLogObject();
				clientErrorLogObject.setClientId(clientLogRequest.getClientId());
				clientErrorLogObject.setFuctionCalled(clientLogRequest.getFuctionCalled());
				clientErrorLogObject.setStatus(clientLogRequest.getStatus());
				clientErrorLogObject.setCurrentDateTime(clientLogRequest.getCurrentDateTime());
				clientErrorLogRepository.save(clientErrorLogObject);
				
				transactionManager.commit(status);

			} catch (Exception ex) {

				try {
					transactionManager.rollback(status);
				} catch (Exception e) {
					logger.error(e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(e) + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getFuctionCalled() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getCurrentDateTime());
				}

				logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(ex) + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getFuctionCalled() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getCurrentDateTime());

			}
		}

		
	}

}
