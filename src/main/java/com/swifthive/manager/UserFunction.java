package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.repository.UserFunctionRepository;
import com.swifthive.utilities.Util;
import com.swifthive.model.userfunction.CreateUserFunctionRequest;

@Service
@Transactional
public class UserFunction {

	private static final Logger logger = LogManager.getLogger(UserFunction.class);
	private UserFunctionObject userFunctionObject;
	private Iterable<UserFunctionObject> iUserFunctionObject;
	private Response rsp;

	@Autowired
	UserFunctionRepository userFunctionRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	public Response processCreateUserFunction(@Valid CreateUserFunctionRequest createUserFunctionRequest) {

		try {
			// persist function information
			userFunctionObject = new UserFunctionObject();
			userFunctionObject.setClientId(createUserFunctionRequest.getClientId());
			userFunctionObject.setFunctionName(createUserFunctionRequest.getFunctionName());
			userFunctionObject.setCreatedBy(createUserFunctionRequest.getUserId());
			userFunctionObject.setStatus("0");
			userFunctionObject.setDateCreated(LocalDateTime.now());
			if (userFunctionRepository.existsByFunctionName(userFunctionObject.getFunctionName())) {
				return util.responseBuilder(createUserFunctionRequest.getClientId(),
						createUserFunctionRequest.getClientId(), 7);
			} else {
				userFunctionRepository.save(userFunctionObject);
				rsp = util.responseBuilder(0L, userFunctionObject.getUniqueId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getRequestNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;

			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, createUserFunctionRequest.getClientId(), 99);
		}
	}

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

	public Response processPendingAuthorization(@Valid PendingAuthorizationRequest pendingAuthorizationRequest) {

		try {
			// check if function information exist
			userFunctionObject = new UserFunctionObject();
			userFunctionObject = userFunctionRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (userFunctionObject.getUniqueId().equals(null)) {
				return util.responseBuilder(userFunctionObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
						30);
			} else {
				// persist function information
				userFunctionObject.setUniqueId(userFunctionObject.getUniqueId());
				userFunctionObject.setCreatedBy(userFunctionObject.getCreatedBy());
				userFunctionObject.setDateCreated(userFunctionObject.getDateCreated());
				userFunctionObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				userFunctionObject.setFunctionName(pendingAuthorizationRequest.getActionValue());
				userFunctionObject.setApprovedBy(pendingAuthorizationRequest.getUserId());
				userFunctionObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
				userFunctionObject.setDateApproved(LocalDateTime.now());
				userFunctionRepository.save(userFunctionObject);
				rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getApprovalNotificationHeading(),
						emailMessages.getApprovalNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}
}
