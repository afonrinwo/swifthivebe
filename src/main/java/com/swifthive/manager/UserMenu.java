/**
 * 
 */
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
import com.swifthive.model.menu.MenuRequest;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MapMenuRequest;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.repository.MapMenuRepository;
import com.swifthive.repository.MenuRepository;
import com.swifthive.utilities.Util;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Service
@Transactional
public class UserMenu {

	private static final Logger logger = LogManager.getLogger(UserMenu.class);

	private MenuObject menuObject;
	private MapMenuObject mapMenuObject;
	private Iterable<MenuObject> iUserMenuObject;
	private Iterable<MapMenuObject> iMapMenuObject;
	private Response rsp;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	MapMenuRepository mapMenuRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Transactional
	public Response processCreateMenu(@Validated MenuRequest menuRequest) {
		try {
			// check if function information exist
			if (menuRepository.existsByMenuName(menuRequest.getMenuName())) {
				return util.responseBuilder(menuObject.getUniqueId(), menuRequest.getClientId(), 7);
			} else {
				// execute your business logic here, persist function information
				menuObject = new MenuObject();
				menuObject.setMerchantId(menuRequest.getMerchantId());
				menuObject.setClientId(menuRequest.getClientId());
				menuObject.setMenuName(menuRequest.getMenuName());
				menuObject.setCreatedBy(menuRequest.getUserId());
				menuObject.setDateCreated(LocalDateTime.now());
				menuObject.setStatus("0");
				menuRepository.save(menuObject);
				rsp = util.responseBuilder(0L, menuRequest.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getPendingNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, menuRequest.getClientId(), 99);
		}
	}

	public Iterable<MenuObject> processListMenu() {
		try {
			iUserMenuObject = menuRepository.findAll();
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}
		return iUserMenuObject;
	}

	public Iterable<MenuObject> processListMenuAPL(String status) {
		try {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject = menuRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}

		return iUserMenuObject;
	}

	public Response processMapMenu(@Validated MapMenuRequest mapMenuRequest) {
		try {
			// check if function and role information exist
			if (mapMenuRepository.existsByFunctionNameAndRoleName(mapMenuRequest.getFunctionName(),
					mapMenuRequest.getRoleName())) {
				return util.responseBuilder(0L, mapMenuRequest.getClientId(), 7);
			} else {
				// persist function information
				mapMenuObject = new MapMenuObject();
				mapMenuObject.setMerchantId(mapMenuRequest.getMerchantId());
				mapMenuObject.setClientId(mapMenuRequest.getClientId());
				mapMenuObject.setFunctionName(mapMenuRequest.getFunctionName());
				mapMenuObject.setRoleName(mapMenuRequest.getRoleName());
				mapMenuObject.setSelectedMenuList(mapMenuRequest.getSelectedMenuList());
				mapMenuObject.setCreatedBy(mapMenuRequest.getUserName());
				mapMenuObject.setDateCreated(LocalDateTime.now());
				mapMenuObject.setStatus("0");
				mapMenuRepository.save(mapMenuObject);
				rsp = util.responseBuilder(0L, mapMenuObject.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getPendingNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, mapMenuRequest.getClientId(), 0);
		}
	}

	public Iterable<MapMenuObject> processListMapMenu() {
		try {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject = mapMenuRepository.findAll();
		} catch (Exception ex) {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject.forEach(null);
		}
		return iMapMenuObject;
	}

	public Iterable<MapMenuObject> processMapMenuAPL(String status) {
		try {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject = mapMenuRepository.findByStatus(status);
		} catch (Exception ex) {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject.forEach(null);
		}

		return iMapMenuObject;
	}

	public Response processPendingAuthorization(@Validated PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {

			if (pendingAuthorizationRequest.getActionCall().equals("UserMenu")) {

				// check if menu information exist
				menuObject = new MenuObject();
				menuObject = menuRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
				if (menuObject.getUniqueId().equals(null)) {
					return util.responseBuilder(menuObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
							30);
				} else {
					// persist function information
					menuObject.setUniqueId(menuObject.getUniqueId());
					menuObject.setCreatedBy(menuObject.getCreatedBy());
					menuObject.setDateCreated(menuObject.getDateCreated());
					menuObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
					menuObject.setMenuName(pendingAuthorizationRequest.getActionValue());
					menuObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
					menuObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
					menuObject.setDateApproved(LocalDateTime.now());
					menuRepository.save(menuObject);
					rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
							"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getApprovalNotificationHeading(),
							emailMessages.getApprovalNotificationMessage());
					return rsp;
				}
			} else {
				// check if menu information exist
				mapMenuObject = new MapMenuObject();
				mapMenuObject = mapMenuRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
				if (mapMenuObject.getUniqueId().equals(null)) {
					return util.responseBuilder(mapMenuObject.getUniqueId(), pendingAuthorizationRequest.getClientId(),
							30);
				} else {
					// persist function information
					mapMenuObject.setUniqueId(mapMenuObject.getUniqueId());
					mapMenuObject.setCreatedBy(mapMenuObject.getCreatedBy());
					mapMenuObject.setDateCreated(mapMenuObject.getDateCreated());
					mapMenuObject.setFunctionName(mapMenuObject.getFunctionName());
					mapMenuObject.setRoleName(mapMenuObject.getRoleName());
					mapMenuObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
					mapMenuObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
					mapMenuObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
					mapMenuObject.setDateApproved(LocalDateTime.now());
					mapMenuRepository.save(mapMenuObject);
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
