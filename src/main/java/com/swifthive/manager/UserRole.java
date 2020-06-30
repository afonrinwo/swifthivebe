package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.userrole.CreateRoleRequest;
import com.swifthive.model.userrole.UserRoleObject;
import com.swifthive.repository.UserRoleRepository;
import com.swifthive.utilities.Util;

@Service
@Transactional
public class UserRole {

	private static final Logger logger = LogManager.getLogger(UserRole.class);
	private UserRoleObject userRoleObject;
	private Iterable<UserRoleObject> iUserRoleObject;
	private Response rsp;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Transactional
	public Response processCreateRole(@Valid CreateRoleRequest createRoleRequest) {
		try {
			// persist function information
			userRoleObject = new UserRoleObject();
			userRoleObject.setClientId(createRoleRequest.getClientId());
			userRoleObject.setRoleName(createRoleRequest.getRoleName());
			userRoleObject.setCreatedBy(createRoleRequest.getUserId());
			userRoleObject.setDateCreated(LocalDateTime.now());
			userRoleObject.setStatus("0");
			if (userRoleRepository.existsByRoleName(userRoleObject.getRoleName())) {
				return util.responseBuilder(0L, createRoleRequest.getClientId(), 7);
			} else {
				userRoleRepository.save(userRoleObject);
				rsp = util.responseBuilder(userRoleObject.getUniqueId(), userRoleObject.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getRequestNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, createRoleRequest.getClientId(), 99);
		}
	}

	public Iterable<UserRoleObject> processListUserRole() {
		try {
			iUserRoleObject = userRoleRepository.findAll();
		} catch (Exception ex) {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject.forEach(null);
		}
		return iUserRoleObject;
	}

	public Iterable<UserRoleObject> processListUserRoleAPL(String status) {
		try {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject = userRoleRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject.forEach(null);
		}

		return iUserRoleObject;
	}

	public Response processPendingAuthorization(@Valid PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {
			// check if role information exist
			userRoleObject = new UserRoleObject();
			userRoleObject = userRoleRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (userRoleObject.getUniqueId().equals(null)) {
				return util.responseBuilder(userRoleObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
						30);
			} else {
				// persist function information
				userRoleObject.setUniqueId(userRoleObject.getUniqueId());
				userRoleObject.setCreatedBy(userRoleObject.getCreatedBy());
				userRoleObject.setDateCreated(userRoleObject.getDateCreated());
				userRoleObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				userRoleObject.setRoleName(pendingAuthorizationRequest.getActionValue());
				userRoleObject.setApprovedBy(pendingAuthorizationRequest.getUserId());
				userRoleObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
				userRoleObject.setDateApproved(LocalDateTime.now());
				userRoleRepository.save(userRoleObject);
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
