package com.swifthive.manager;

import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.swifthive.model.ClientAuditLogObject;
import com.swifthive.model.ClientErrorLogObject;
import com.swifthive.model.ClientLogRequest;
import com.swifthive.repository.ClientAuditLogRepository;
import com.swifthive.repository.ClientErrorLogRepository;

@Service
@Transactional
public class ClientLog {
	
	private static final Logger logger = LogManager.getLogger(ClientLog.class);

	private ClientErrorLogObject clientErrorLogObject;
	private ClientAuditLogObject clientAuditLogObject;

	@Autowired
	ClientErrorLogRepository clientErrorLogRepository;

	@Autowired
	ClientAuditLogRepository clientAuditLogRepository;

	public void processClientLog(@Validated ClientLogRequest clientLogRequest) {

		if("AUDIT".equals(clientLogRequest.getLogType().toUpperCase())) {
			try {
				// persist function information
				clientAuditLogObject = new ClientAuditLogObject();
				clientAuditLogObject.setClientId(clientLogRequest.getClientId());
				clientAuditLogObject.setMerchantId(clientLogRequest.getMerchantId());
				clientAuditLogObject.setUserId(clientLogRequest.getUserId());
				clientAuditLogObject.setFunctionCalled(clientLogRequest.getFunctionCalled());
				clientAuditLogObject.setActivity(clientLogRequest.getActivity());
				clientAuditLogObject.setStatus(clientLogRequest.getStatus());
				clientAuditLogObject.setMessage(clientLogRequest.getMessage());
				clientAuditLogObject.setLogTime(clientLogRequest.getLogTime());
				clientAuditLogRepository.save(clientAuditLogObject);
			} catch (Exception ex) {
				logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace() + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getUserId() + "\n" + clientLogRequest.getFunctionCalled() + "\n" + clientLogRequest.getActivity() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getMessage() + "\n" + clientLogRequest.getLogTime());
			}
		} else {
			
			try {
				// persist audit log function information 
				clientAuditLogObject = new ClientAuditLogObject();
				clientAuditLogObject.setClientId(clientLogRequest.getClientId());
				clientAuditLogObject.setMerchantId(clientLogRequest.getMerchantId());
				clientAuditLogObject.setUserId(clientLogRequest.getUserId());
				clientAuditLogObject.setFunctionCalled(clientLogRequest.getFunctionCalled());
				clientAuditLogObject.setActivity(clientLogRequest.getActivity());
				clientAuditLogObject.setStatus(clientLogRequest.getStatus());
				clientAuditLogObject.setMessage(clientLogRequest.getMessage());
				clientAuditLogObject.setLogTime(clientLogRequest.getLogTime());
				clientAuditLogRepository.save(clientAuditLogObject);
				
				// persist error log function information 
				clientErrorLogObject = new ClientErrorLogObject();
				clientErrorLogObject.setClientId(clientLogRequest.getClientId());
				clientErrorLogObject.setMerchantId(clientLogRequest.getMerchantId());
				clientErrorLogObject.setUserId(clientLogRequest.getUserId());
				clientErrorLogObject.setFunctionCalled(clientLogRequest.getFunctionCalled());
				clientErrorLogObject.setActivity(clientLogRequest.getActivity());
				clientErrorLogObject.setStatus(clientLogRequest.getStatus());
				clientErrorLogObject.setMessage(clientLogRequest.getMessage());
				clientErrorLogObject.setLogTime(clientLogRequest.getLogTime());
				clientErrorLogRepository.save(clientErrorLogObject);

			} catch (Exception ex) {
				logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace() + "\n" + clientLogRequest.getClientId() + "\n" + clientLogRequest.getUserId() + "\n" + clientLogRequest.getFunctionCalled() + "\n" + clientLogRequest.getActivity() + "\n" + clientLogRequest.getStatus() + "\n" + clientLogRequest.getMessage() + "\n" + clientLogRequest.getLogTime());
			}
		}
	}

}
