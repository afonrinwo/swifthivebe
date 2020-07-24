package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.role.RoleRequest;
import com.swifthive.model.role.RoleObject;
import com.swifthive.repository.ProfileKeyRepository;
import com.swifthive.repository.ProfileRepository;
import com.swifthive.repository.RoleRepository;
import com.swifthive.utilities.Util;


/**
 * @author emmanuel.afonrinwo
 *
 */
@Service
@Transactional
public class UserRole {

	private static final Logger logger = LogManager.getLogger(UserRole.class);
	private RoleObject roleObject;
	private ProfileObject profileObject;
	private Iterable<RoleObject> iUserRoleObject;
	private Response rsp;
	
	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ProfileKeyRepository profileKeyRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Transactional
	public Response processCreateRole(@Validated RoleRequest roleRequest) {
		try {

			if (roleRepository.existsByRoleName(roleRequest.getRoleName())) {
				return util.responseBuilder(0L, roleRequest.getClientId(), 7);
			} else {
				// persist function information
				roleObject = new RoleObject();
				roleObject.setMerchantId(roleRequest.getMerchantId());
				roleObject.setClientId(roleRequest.getClientId());
				roleObject.setRoleName(roleRequest.getRoleName());
				roleObject.setCreatedBy(roleRequest.getUserId());
				roleObject.setDateCreated(LocalDateTime.now());
				roleObject.setStatus(0);
				roleRepository.save(roleObject);
				rsp = util.responseBuilder(roleObject.getUniqueId(), roleObject.getClientId(), 0);
				
				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(roleObject.getCreatedBy());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						profileObject.getEmail(), emailMessages.getPendingNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, roleRequest.getClientId(), 99);
		}
	}

	public Iterable<RoleObject> processListRole() {
		try {
			iUserRoleObject = roleRepository.findAll();
		} catch (Exception ex) {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject.forEach(null);
		}
		return iUserRoleObject;
	}

	public Iterable<RoleObject> processListRoleAPL(String status) {
		try {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject = roleRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserRoleObject = new ArrayList<>();
			iUserRoleObject.forEach(null);
		}

		return iUserRoleObject;
	}

	public Response processPendingAuthorization(@Validated PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {
			// check if role information exist
			roleObject = new RoleObject();
			roleObject = roleRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (roleObject.getUniqueId().equals(null)) {
				return util.responseBuilder(roleObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
						30);
			} else {
				// persist function information
				roleObject.setUniqueId(roleObject.getUniqueId());
				roleObject.setCreatedBy(roleObject.getCreatedBy());
				roleObject.setDateCreated(roleObject.getDateCreated());
				roleObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				roleObject.setRoleName(pendingAuthorizationRequest.getActionValue());
				roleObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
				roleObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? 1 : 2);
				roleObject.setDateApproved(LocalDateTime.now());
				roleRepository.save(roleObject);
				rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
				
				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(roleObject.getCreatedBy());
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
