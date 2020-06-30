/**
 * 
 */
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
import com.swifthive.model.usermenu.CreateUserMenuRequest;
import com.swifthive.model.usermenu.UserMenuMappingRequest;
import com.swifthive.model.usermenu.UserMenuMappingObject;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.repository.UserMenuMappingRepository;
import com.swifthive.repository.UserMenuRepository;
import com.swifthive.utilities.Util;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Service
@Transactional
public class UserMenu {

	private static final Logger logger = LogManager.getLogger(UserMenu.class);

	private UserMenuObject userMenuObject;
	private UserMenuMappingObject userMenuMappingObject;
	private Iterable<UserMenuObject> iUserMenuObject;
	private Iterable<UserMenuMappingObject> iUserMenuMappingObject;
	private Response rsp;

	@Autowired
	UserMenuRepository userMenuRepository;

	@Autowired
	UserMenuMappingRepository userMenuMappingRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Transactional
	public Response processCreateMenu(@Valid CreateUserMenuRequest createUserMenuRequest) {
		try {
			// execute your business logic here, persist function information
			userMenuObject = new UserMenuObject();
			userMenuObject.setClientId(createUserMenuRequest.getClientId());
			userMenuObject.setMenuName(createUserMenuRequest.getMenuName());
			userMenuObject.setCreatedBy(createUserMenuRequest.getUserId());
			userMenuObject.setDateCreated(LocalDateTime.now());
			userMenuObject.setStatus("0");
			if (userMenuRepository.existsByMenuName(userMenuObject.getMenuName())) {
				return util.responseBuilder(userMenuObject.getUniqueId(), createUserMenuRequest.getClientId(), 7);
			} else {
				userMenuRepository.save(userMenuObject);
				rsp = util.responseBuilder(0L, createUserMenuRequest.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getRequestNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, createUserMenuRequest.getClientId(), 99);
		}
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
		try {
			// persist function information
			userMenuMappingObject = new UserMenuMappingObject();
			userMenuMappingObject.setClientId(userMenuMappingRequest.getClientId());
			userMenuMappingObject.setFunctionName(userMenuMappingRequest.getFunctionName());
			userMenuMappingObject.setRoleName(userMenuMappingRequest.getRoleName());
			userMenuMappingObject.setSelectedMenuList(userMenuMappingRequest.getSelectedMenuList());
			userMenuMappingObject.setCreatedBy(userMenuMappingRequest.getUserId());
			userMenuMappingObject.setDateCreated(LocalDateTime.now());
			userMenuMappingObject.setStatus("0");
			if (userMenuMappingRepository.existsByFunctionNameAndRoleName(userMenuMappingObject.getFunctionName(),
					userMenuMappingObject.getRoleName())) {
				return util.responseBuilder(0L, userMenuMappingRequest.getClientId(), 7);
			} else {
				userMenuMappingRepository.save(userMenuMappingObject);
				rsp = util.responseBuilder(0L, userMenuMappingObject.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getRequestNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, userMenuMappingRequest.getClientId(), 0);
		}
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

	public Response processPendingAuthorization(@Valid PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {

			if (pendingAuthorizationRequest.getActionCall().equals("UserMenu")) {

				// check if menu information exist
				userMenuObject = new UserMenuObject();
				userMenuObject = userMenuRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
				if (userMenuObject.getUniqueId().equals(null)) {
					return util.responseBuilder(userMenuObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
							30);
				} else {
					// persist function information
					userMenuObject.setUniqueId(userMenuObject.getUniqueId());
					userMenuObject.setCreatedBy(userMenuObject.getCreatedBy());
					userMenuObject.setDateCreated(userMenuObject.getDateCreated());
					userMenuObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
					userMenuObject.setMenuName(pendingAuthorizationRequest.getActionValue());
					userMenuObject.setApprovedBy(pendingAuthorizationRequest.getUserId());
					userMenuObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
					userMenuObject.setDateApproved(LocalDateTime.now());
					userMenuRepository.save(userMenuObject);
					rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
							"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getApprovalNotificationHeading(),
							emailMessages.getApprovalNotificationMessage());
					return rsp;
				}
			} else {
				// check if menu information exist
				userMenuMappingObject = new UserMenuMappingObject();
				userMenuMappingObject = userMenuMappingRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
				if (userMenuMappingObject.getUniqueId().equals(null)) {
					return util.responseBuilder(userMenuMappingObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
							30);
				} else {
					// persist function information
					userMenuMappingObject.setUniqueId(userMenuMappingObject.getUniqueId());
					userMenuMappingObject.setCreatedBy(userMenuMappingObject.getCreatedBy());
					userMenuMappingObject.setDateCreated(userMenuMappingObject.getDateCreated());
					userMenuMappingObject.setFunctionName(userMenuMappingObject.getFunctionName());
					userMenuMappingObject.setRoleName(userMenuMappingObject.getRoleName());
					userMenuMappingObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
					userMenuMappingObject.setApprovedBy(pendingAuthorizationRequest.getUserId());
					userMenuMappingObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
					userMenuMappingObject.setDateApproved(LocalDateTime.now());
					userMenuMappingRepository.save(userMenuMappingObject);
					rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
							"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getApprovalNotificationHeading(),
							emailMessages.getApprovalNotificationMessage());
					return rsp;
				}

			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}

}
