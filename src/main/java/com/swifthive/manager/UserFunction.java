package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.function.FunctionRequest;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.function.FunctionObject;
import com.swifthive.repository.FunctionRepository;
import com.swifthive.repository.ProfileRepository;
import com.swifthive.utilities.Util;

@Service
@Transactional
public class UserFunction {

	private static final Logger logger = LogManager.getLogger(UserFunction.class);
	private FunctionObject functionObject;
	private ProfileObject profileObject;
	private Iterable<FunctionObject> iUserFunctionObject;
	private Response rsp;

	@Autowired
	FunctionRepository functionRepository;
	
	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	public Response processCreateFunction(@Validated FunctionRequest functionRequest) {

		try {
			// check if function information exist
			if (functionRepository.existsByFunctionName(functionRequest.getFunctionName())) {
				return util.responseBuilder(functionObject.getUniqueId(),functionRequest.getClientId(), 7);
			} else {
				// persist function information
				functionObject = new FunctionObject();
				functionObject.setMerchantId(functionRequest.getMerchantId());			
				functionObject.setClientId(functionRequest.getClientId());
				functionObject.setFunctionName(functionRequest.getFunctionName());
				functionObject.setCreatedBy(functionRequest.getUserId());
				functionObject.setStatus(0);
				functionObject.setDateCreated(LocalDateTime.now());
				functionRepository.save(functionObject);
				rsp = util.responseBuilder(0L, functionObject.getUniqueId(), 0);
				
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getPendingNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;

			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, functionRequest.getClientId(), 99);
		}
	}

	public Iterable<FunctionObject> processListFunction() {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = functionRepository.findAll();
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}
		return iUserFunctionObject;
	}

	public Iterable<FunctionObject> processListFunctionAPL(String status) {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = functionRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}

		return iUserFunctionObject;
	}

	public Response processPendingAuthorization(@Validated PendingAuthorizationRequest pendingAuthorizationRequest) {

		try {
			// check if function information exist
			functionObject = new FunctionObject();
			functionObject = functionRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (functionObject.getUniqueId().equals(null)) {
				return util.responseBuilder(functionObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
						30);
			} else {
				// persist function information
				functionObject.setUniqueId(functionObject.getUniqueId());
				functionObject.setCreatedBy(functionObject.getCreatedBy());
				functionObject.setDateCreated(functionObject.getDateCreated());
				functionObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				functionObject.setFunctionName(pendingAuthorizationRequest.getActionValue());
				functionObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
				functionObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? 1 : 2);
				functionObject.setDateApproved(LocalDateTime.now());
				functionRepository.save(functionObject);
				rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
				
				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(functionObject.getCreatedBy());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						profileObject.getEmail(), emailMessages.getApprovalNotificationHeading(),
						emailMessages.getApprovalNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}
}
