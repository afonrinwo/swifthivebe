/**
 * 
 */
package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.ResponseCode;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.profile.CreateProfileRequest;
import com.swifthive.model.profile.NavAccessRightRequest;
import com.swifthive.model.profile.PasswordChangeRequest;
import com.swifthive.model.profile.ProfileKeyObject;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.profile.UserLoginRequest;
import com.swifthive.model.profile.UserLoginResponse;
import com.swifthive.repository.MapMenuRepository;
import com.swifthive.repository.MenuRepository;
import com.swifthive.repository.ProfileKeyRepository;
import com.swifthive.repository.ProfileRepository;
import com.swifthive.utilities.Util;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Service
@Transactional
public class UserProfile {

	private static final Logger logger = LogManager.getLogger(UserFunction.class);
	private ProfileObject profileObject;
	private ProfileKeyObject profileKeyObject;
	private MapMenuObject mapMenuObject;
	private Iterable<ProfileObject> iProfileObject;
	private Iterable<MenuObject> iMenuObject;
	private Response rsp;
	private UserLoginResponse userLoginResponse;
	private StringBuilder stringBuilder;

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ProfileKeyRepository profileKeyRepository;

	@Autowired
	MapMenuRepository mapMenuRepository;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	@Autowired
	ResponseCode responseCode;

	public Response processCreateUserProfile(@Validated CreateProfileRequest createProfileRequest) {
		try {
			// check if function information exist
			if (profileRepository.existsByUserName(createProfileRequest.getUserName())) {
				return util.responseBuilder(createProfileRequest.getClientId(), profileObject.getUniqueId(), 7);
			} else {
				// persist profile parameters function information
				profileObject = new ProfileObject();
				profileObject.setClientId(createProfileRequest.getClientId());
				profileObject.setCreatedBy(createProfileRequest.getUserId());
				profileObject.setDateCreated(LocalDateTime.now());
				profileObject.setEmail(createProfileRequest.getEmail());
				profileObject.setFirstName(createProfileRequest.getFirstName());
				profileObject.setFunctionName(createProfileRequest.getFunctionName());
				profileObject.setLastName(createProfileRequest.getLastName());
				profileObject.setMobileNumber(createProfileRequest.getMobileNumber());
				profileObject.setRoleName(createProfileRequest.getRoleName());
				profileObject.setMerchantId(createProfileRequest.getMerchantId());
				profileObject.setStatus(0);
				profileObject.setUserName(createProfileRequest.getUserName());
				profileObject.setDateCreated(LocalDateTime.now());
				profileRepository.save(profileObject);

				if (profileObject.getUniqueId() == null) {
					return util.responseBuilder(0L, profileObject.getUniqueId(), 99);
				}

				// persist profile parameters function information
				profileKeyObject = new ProfileKeyObject();
				profileKeyObject.setUniqueId(profileObject.getUniqueId());
				profileKeyObject.setMerchantId(createProfileRequest.getMerchantId());
				profileKeyObject.setMobileNumber(createProfileRequest.getMobileNumber());
				profileKeyObject.setEmail(createProfileRequest.getEmail());
				String rKey = RandomStringUtils.randomAlphanumeric(6);
				profileKeyObject.setOffSet(util.encryptString(util.encryptString(util.accessValidation(rKey)),
						createProfileRequest.getUserName()));
				profileKeyObject.setUserName(createProfileRequest.getUserName());
				profileKeyObject.setPasswordCount(0);
				profileKeyRepository.save(profileKeyObject);

				rsp = util.responseBuilder(0L, profileObject.getUniqueId(), 0);
				
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
						emailMessages.getUserCreationHeading(), String.format(emailMessages.getUserCreationMessage(),
								createProfileRequest.getUserName(), rKey));
				
				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(profileObject.getCreatedBy());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
						emailMessages.getPendingNotificationHeading(), String.format(emailMessages.getPendingNotificationMessage()));
				return rsp;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, createProfileRequest.getClientId(), 99);
		}
	}

	public Iterable<ProfileObject> processUserProfileAPL(String status) {
		try {
			iProfileObject = new ArrayList<>();
			iProfileObject = profileRepository.findByStatus(status);
		} catch (Exception ex) {
			iProfileObject = new ArrayList<>();
			iProfileObject.forEach(null);
		}

		return iProfileObject;
	}

	public Response processPendingAuthorization(PendingAuthorizationRequest pendingAuthorizationRequest) {
		try {
			// check if function information exist
			profileObject = new ProfileObject();
			profileObject = profileRepository.findByUniqueId(pendingAuthorizationRequest.getUniqueId());
			if (profileObject.getUniqueId().equals(null)) {
				return util.responseBuilder(profileObject.getUniqueId(), pendingAuthorizationRequest.getClientId(), 30);
			} else {
				// persist function information
				profileObject.setUniqueId(profileObject.getUniqueId());
				profileObject.setCreatedBy(profileObject.getCreatedBy());
				profileObject.setDateCreated(profileObject.getDateCreated());
				profileObject.setApprovedClientId(pendingAuthorizationRequest.getClientId());
				profileObject.setFunctionName(pendingAuthorizationRequest.getActionValue());
				profileObject.setApprovedBy(pendingAuthorizationRequest.getUserName());
				profileObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? 1 : 2);
				profileObject.setDateApproved(LocalDateTime.now());
				profileRepository.save(profileObject);
				rsp = util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 0);
				
				
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileObject.getEmail(),
						emailMessages.getApprovalNotificationHeading(), String.format(emailMessages.getApprovalNotificationMessage()));
				
				profileObject = new ProfileObject();
				profileObject = profileRepository.findByUserName(profileKeyObject.getEmail());
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(),
						profileObject.getEmail(), emailMessages.getUserCreationApprovalHeading(),
						emailMessages.getUserCreationApprovalMessage());

				
				return rsp;
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 99);
		}
	}

	public Iterable<ProfileObject> processUserProfile() {
		try {
			iProfileObject = new ArrayList<>();
			iProfileObject = profileRepository.findAll();
		} catch (Exception ex) {
			iProfileObject = new ArrayList<>();
			iProfileObject.forEach(null);
		}
		return iProfileObject;
	}

	public UserLoginResponse processUserLogin(UserLoginRequest userLoginRequest) {

		try {
			stringBuilder = new StringBuilder();
			profileObject = profileRepository.findByMerchantIdAndUserName(userLoginRequest.getMerchantId(),
					userLoginRequest.getUserName());
			switch (profileObject.getStatus()) {
			case 0:
				userLoginResponse = new UserLoginResponse();
				userLoginResponse.setClientId(profileObject.getClientId());
				userLoginResponse.setMerchantId(profileObject.getMerchantId());
				userLoginResponse.setUserName(profileObject.getUserName());
				userLoginResponse.setResponseCode(String.format("%03d", 31));
				userLoginResponse.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[31]).toString());
				return userLoginResponse;
			case 1:
				profileKeyObject = new ProfileKeyObject();
				profileKeyObject = profileKeyRepository.findByMerchantIdAndUserName(userLoginRequest.getMerchantId(),
						userLoginRequest.getUserName());
				switch (profileKeyObject.getPasswordCount()) {
				case 0:
					userLoginResponse = new UserLoginResponse();
					userLoginResponse.setClientId(userLoginRequest.getClientId());
					userLoginResponse.setMerchantId(userLoginRequest.getMerchantId());
					userLoginResponse.setUserName(userLoginRequest.getUserName());
					userLoginResponse.setResponseCode(String.format("%03d", 33));
					userLoginResponse
							.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[33]).toString());
					return userLoginResponse;
				default:
					if (profileKeyObject.getOffSet().equals(
							util.encryptString(userLoginRequest.getPassword(), userLoginRequest.getUserName()))) {
						userLoginResponse = new UserLoginResponse();
						userLoginResponse.setClientId(profileObject.getClientId());
						userLoginResponse.setMerchantId(profileObject.getMerchantId());
						userLoginResponse.setFirstName(profileObject.getFirstName());
						userLoginResponse.setFunctionName(profileObject.getFunctionName());
						userLoginResponse.setLastName(profileObject.getLastName());
						userLoginResponse.setMerchantId(profileObject.getMerchantId());
						userLoginResponse.setResponseCode(String.format("%03d", 0));
						userLoginResponse.setResponseMessage(
								stringBuilder.append(responseCode.getResponseMessage()[0]).toString());
						userLoginResponse.setRoleName(profileObject.getRoleName());
						userLoginResponse.setStatus(profileObject.getStatus());
						userLoginResponse.setUniqueId(profileObject.getUniqueId());
						userLoginResponse.setUserName(profileObject.getUserName());
						return userLoginResponse;
					} else {
						userLoginResponse = new UserLoginResponse();
						userLoginResponse.setClientId(userLoginRequest.getClientId());
						userLoginResponse.setMerchantId(userLoginRequest.getMerchantId());
						userLoginResponse.setUserName(userLoginRequest.getUserName());
						userLoginResponse.setResponseCode(String.format("%03d", 23));
						userLoginResponse.setResponseMessage(
								stringBuilder.append(responseCode.getResponseMessage()[23]).toString());
						return userLoginResponse;
					}
				}
			default:
				userLoginResponse = new UserLoginResponse();
				userLoginResponse.setClientId(profileObject.getClientId());
				userLoginResponse.setMerchantId(profileObject.getMerchantId());
				userLoginResponse.setUserName(profileObject.getUserName());
				userLoginResponse.setResponseCode(String.format("%03d", 33));
				userLoginResponse
						.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[33]).toString());
				return userLoginResponse;
			}

		} catch (

		Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			userLoginResponse = new UserLoginResponse();
			userLoginResponse.setClientId(userLoginRequest.getClientId());
			userLoginResponse.setMerchantId(userLoginRequest.getMerchantId());
			userLoginResponse.setUserName(userLoginRequest.getUserName());
			if (ex instanceof NullPointerException) {
				userLoginResponse.setResponseCode(String.format("%03d", 34));
				userLoginResponse
						.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[34]).toString());
				return userLoginResponse;
			} else {
				userLoginResponse.setResponseCode(String.format("%03d", 99));
				userLoginResponse
						.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[99]).toString());
				return userLoginResponse;
			}
		}
	}

	public Response processPasswordChange(PasswordChangeRequest passwordChangeRequest) {
		try {
			profileKeyObject = new ProfileKeyObject();
			profileKeyObject = profileKeyRepository.findByMerchantIdAndUserName(passwordChangeRequest.getMerchantId(),
					passwordChangeRequest.getUserName());
			if (profileKeyObject.getOffSet().equals(
					util.encryptString(passwordChangeRequest.getOldPassword(), passwordChangeRequest.getUserName()))) {
				profileKeyObject.setEmail(profileKeyObject.getEmail());
				profileKeyObject.setMerchantId(profileKeyObject.getMerchantId());
				profileKeyObject.setMobileNumber(profileKeyObject.getMobileNumber());
				profileKeyObject.setOffSet(util.encryptString(passwordChangeRequest.getNewPassword(),
						passwordChangeRequest.getUserName()));
				profileKeyObject.setPasswordCount(profileKeyObject.getPasswordCount() + 1);
				profileKeyObject.setLastPasswordChangeDate(LocalDateTime.now());
				profileKeyObject.setUniqueId(profileKeyObject.getUniqueId());
				profileKeyObject.setUserName(profileKeyObject.getUserName());
				profileKeyObject = profileKeyRepository.save(profileKeyObject);
				rsp = util.responseBuilder(0L, passwordChangeRequest.getClientId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileKeyObject.getEmail(),
						emailMessages.getPasswordChangeHeading(), emailMessages.getPasswordChangeMessage());
				return rsp;
			} else {
				return util.responseBuilder(0L, passwordChangeRequest.getClientId(), 23);
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return util.responseBuilder(0L, passwordChangeRequest.getClientId(), 99);
		}

	}

	public Iterable<MenuObject> processNavAccessRight(NavAccessRightRequest navAccessRightRequest) {

		try {
			// select user from profile
			profileObject = new ProfileObject();
			profileObject = profileRepository.findByMerchantIdAndUserName(navAccessRightRequest.getMerchantId(),
					navAccessRightRequest.getUserName());

			// get user function ans role
			mapMenuObject = new MapMenuObject();
			mapMenuObject = mapMenuRepository.findByMerchantIdAndRoleName(profileObject.getMerchantId(),
					profileObject.getRoleName());

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
