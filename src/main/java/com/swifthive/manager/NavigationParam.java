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

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.menu.NavigationParamObject;
import com.swifthive.model.menu.NavigationParamRequest;
import com.swifthive.repository.NavigationParamRepository;
import com.swifthive.utilities.Util;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
@Transactional
public class NavigationParam {

	private static final Logger logger = LogManager.getLogger(NavigationParam.class);

	private NavigationParamObject navigationParamObject;
	private Iterable<NavigationParamObject> iNavigationParamObject;
	private Response rsp;

	@Autowired
	NavigationParamRepository navigationParamRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Transactional
	public Response processcreateNavigationParam(NavigationParamRequest navigationParamRequest) {
		try {
			// check if function and role information exist
			if (navigationParamRepository.existsByNavItemAndNavIconAndNavText(navigationParamRequest.getNavItem(),
					navigationParamRequest.getNavIcon(), navigationParamRequest.getNavText())) {
				return util.responseBuilder(0L, navigationParamRequest.getClientId(), 7);
			} else {
				// persist function information
				navigationParamObject = new NavigationParamObject();
				navigationParamObject.setMerchantId(navigationParamRequest.getMerchantId());
				navigationParamObject.setClientId(navigationParamRequest.getClientId());
				navigationParamObject.setNavItem(navigationParamRequest.getNavItem());
				navigationParamObject.setNavIcon(navigationParamRequest.getNavIcon());
				navigationParamObject.setNavText(navigationParamRequest.getNavText());
				navigationParamObject.setCreatedBy(navigationParamRequest.getUserName());
				navigationParamObject.setDateCreated(LocalDateTime.now());
				navigationParamObject.setStatus("0");
				navigationParamRepository.save(navigationParamObject);
				rsp = util.responseBuilder(0L, navigationParamObject.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getPendingNotificationHeading(),
						emailMessages.getPendingNotificationMessage());
				return rsp;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, navigationParamRequest.getClientId(), 99);
		}
	}

	public Iterable<NavigationParamObject> processNavigationParamAPL(String status) {
		try {
			iNavigationParamObject = new ArrayList<>();
			iNavigationParamObject = navigationParamRepository.findByStatus(status);
		} catch (Exception ex) {
			iNavigationParamObject = new ArrayList<>();
			iNavigationParamObject.forEach(null);
		}
		return iNavigationParamObject;
	}

	public Response processPendingAuthorization(PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {
			// check if menu information exist
			navigationParamObject = new NavigationParamObject();
			navigationParamObject = navigationParamRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (navigationParamObject.getUniqueId().equals(null)) {
				return util.responseBuilder(navigationParamObject.getUniqueId(), pendingAuthorizationRequest.getClientId(), 30);
			} else {
				// persist function information
				navigationParamObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
				navigationParamObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				navigationParamObject.setClientId(navigationParamObject.getClientId());
				navigationParamObject.setCreatedBy(navigationParamObject.getCreatedBy());
				navigationParamObject.setDateApproved(LocalDateTime.now());
				navigationParamObject.setDateCreated(navigationParamObject.getDateCreated());
				navigationParamObject.setMerchantId(navigationParamObject.getMerchantId());
				navigationParamObject.setNavIcon(navigationParamObject.getNavIcon());
				navigationParamObject.setNavItem(navigationParamObject.getNavItem());
				navigationParamObject.setNavText(navigationParamObject.getNavText());
				navigationParamObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
				navigationParamObject.setUniqueId(navigationParamObject.getUniqueId());	
				navigationParamRepository.save(navigationParamObject);
				rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						"emmanuel.afonrinwo@swiftsystemsng.com", emailMessages.getApprovalNotificationHeading(),
						emailMessages.getApprovalNotificationMessage());
				return rsp;
			}

		} catch (

		Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}
}
