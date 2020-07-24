/**
 * 
 */
package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

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
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.menu.ListMapMenuRequest;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MapMenuRequest;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.repository.MapMenuRepository;
import com.swifthive.repository.MenuRepository;
import com.swifthive.repository.ProfileRepository;
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
	private ProfileObject profileObject;
	private Iterable<MenuObject> iMenuObject;
	private Iterable<MenuObject> iUserMenuObject;
	private Iterable<MapMenuObject> iMapMenuObject;
	private Response rsp;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	MapMenuRepository mapMenuRepository;

	@Autowired
	ProfileRepository profileRepository;

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
				menuObject.setClientId(menuRequest.getClientId());
				menuObject.setCreatedBy(menuRequest.getUserName());
				menuObject.setDateCreated(LocalDateTime.now());
				menuObject.setMenuCategory(menuRequest.getMenuCategory());
				menuObject.setMenuComponent(menuRequest.getMenuComponent());
				menuObject.setMenuName(menuRequest.getMenuName());
				menuObject.setMenuPath(menuRequest.getMenuPath());
				menuObject.setMerchantId(menuRequest.getMerchantId());
				menuObject.setNavIcon(menuRequest.getNavIcon());
				menuObject.setNavItem(menuRequest.getNavItem());
				menuObject.setStatus(0);
				menuRepository.save(menuObject);
				rsp = util.responseBuilder(0L, menuRequest.getClientId(), 0);

				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(menuObject.getCreatedBy());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
						emailMessages.getPendingNotificationHeading(), emailMessages.getPendingNotificationMessage());
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

	public Iterable<MenuObject> processListMenuAPL(int i) {
		try {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject = menuRepository.findByStatus(i);
		} catch (Exception ex) {
			iUserMenuObject = new ArrayList<>();
			iUserMenuObject.forEach(null);
		}

		return iUserMenuObject;
	}

	public Response processMapMenu(@Validated MapMenuRequest mapMenuRequest) {
		try {

			switch (mapMenuRequest.getAction()) {
			case "update":
				// get existing record
				mapMenuObject = new MapMenuObject();
				mapMenuObject = mapMenuRepository.findByMerchantIdAndFunctionNameAndRoleName(
						mapMenuRequest.getMerchantId(), mapMenuRequest.getFunctionName(), mapMenuRequest.getRoleName());
				// persist function information
				mapMenuObject.setMerchantId(mapMenuObject.getMerchantId());
				mapMenuObject.setClientId(mapMenuRequest.getClientId());
				mapMenuObject.setFunctionName(mapMenuObject.getFunctionName());
				mapMenuObject.setRoleName(mapMenuObject.getRoleName());
				mapMenuObject.setSelectedMenuList(mapMenuRequest.getSelectedMenuList());
				mapMenuObject.setCreatedBy(mapMenuRequest.getUserName());
				mapMenuObject.setDateCreated(LocalDateTime.now());
				mapMenuObject.setStatus(mapMenuObject.getStatus() + 1);
				mapMenuRepository.save(mapMenuObject);
				rsp = util.responseBuilder(0L, mapMenuObject.getClientId(), 0);

				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(menuObject.getCreatedBy());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
						emailMessages.getPendingNotificationHeading(), emailMessages.getPendingNotificationMessage());
				return rsp;

			default:
				// check if function and role information exist
				if (mapMenuRepository.existsByMerchantIdAndFunctionNameAndRoleName(
						mapMenuRequest.getMerchantId(), mapMenuRequest.getFunctionName(), mapMenuRequest.getRoleName())) {
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
					mapMenuObject.setStatus(0);
					mapMenuRepository.save(mapMenuObject);
					rsp = util.responseBuilder(0L, mapMenuObject.getClientId(), 0);

					profileObject = new ProfileObject();
					profileObject = profileRepository.findByUserName(menuObject.getCreatedBy());
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
							emailMessages.getPendingNotificationHeading(),
							emailMessages.getPendingNotificationMessage());
					return rsp;
				}
			}
		} catch (

		Exception ex) {
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

	public Iterable<MapMenuObject> processMapMenuAPL(int i) {
		try {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject = mapMenuRepository.findByStatus(i);
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
					menuObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? 1 : 2);
					menuObject.setDateApproved(LocalDateTime.now());
					menuRepository.save(menuObject);
					rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);

					profileObject = new ProfileObject();
					profileObject = profileRepository.findByUserName(menuObject.getCreatedBy());
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
							emailMessages.getApprovalNotificationHeading(),
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
					mapMenuObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? 1 : 2);
					mapMenuObject.setDateApproved(LocalDateTime.now());
					mapMenuRepository.save(mapMenuObject);
					rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);

					profileObject = new ProfileObject();
					profileObject = profileRepository.findByUserName(mapMenuObject.getCreatedBy());
					util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
							emailMessages.getApprovalNotificationHeading(),
							emailMessages.getApprovalNotificationMessage());
					return rsp;
				}

			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}

	public Iterable<MenuObject> processListMapMenu(ListMapMenuRequest listMapMenuRequest) {
		try {

			// get user function and role
			mapMenuObject = new MapMenuObject();
			mapMenuObject = mapMenuRepository.findByMerchantIdAndFunctionNameAndRoleName(
					listMapMenuRequest.getMerchantId(), listMapMenuRequest.getFunctionName(),
					listMapMenuRequest.getRoleName());

			// use selected menu to get other details
			int[] iIds = Arrays.stream(mapMenuObject.getSelectedMenuList().split("\\|")).mapToInt(Integer::parseInt)
					.toArray();
			long[] lIds = Arrays.stream(iIds).asLongStream().toArray();
			iMenuObject = new ArrayList<>();
			iMenuObject = menuRepository.findAllByUniqueIdIn(lIds);

		} catch (Exception ex) {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
		}

		return iMenuObject;
	}

}
