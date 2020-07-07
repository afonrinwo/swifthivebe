/**
 * 
 */
package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.swifthive.model.EmailMessages;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.profile.CreateProfileRequest;
import com.swifthive.model.profile.ProfileKeyObject;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.profile.UserLoginRequest;
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
	private Iterable<ProfileObject> iProfileObject;
	private Response rsp;

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ProfileKeyRepository profileKeyRepository;

	@Autowired
	Util util;

	@Autowired
	EmailMessages emailMessages;

	public Response processCreateUserProfile(@Validated CreateProfileRequest createProfileRequest)
			throws DataIntegrityViolationException {
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
				profileObject.setStatus("0");
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
				profileKeyObject.setOffSet(util.encryptString(util.encryptString(util.accessValidation(rKey)),createProfileRequest.getUserName()));
				profileKeyObject.setUserName(createProfileRequest.getUserName());
				profileKeyRepository.save(profileKeyObject);

				rsp = util.responseBuilder(0L, profileObject.getUniqueId(), 0);
				util.sendEmailOneRecipient(emailMessages.getNotificationSender(), profileKeyObject.getEmail(),
						emailMessages.getUserCreationHeading(), String.format(emailMessages.getUserCreationMessage(),
								createProfileRequest.getUserName(), rKey));
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
				profileObject.setApprovedBy(pendingAuthorizationRequest.getUserId());
				profileObject.setStatus((pendingAuthorizationRequest.getStatus().equals("approved")) ? "1" : "2");
				profileObject.setDateApproved(LocalDateTime.now());
				profileRepository.save(profileObject);
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

	public Response processUserLogin(UserLoginRequest userLoginRequest) {
		profileKeyObject = new ProfileKeyObject();
		profileKeyObject = profileKeyRepository.findByUserName(userLoginRequest.getUserName());
		if (profileKeyObject.getOffSet()
				.equals(util.encryptString(userLoginRequest.getPassword(), userLoginRequest.getUserName()))) {
			
			return util.responseBuilder(0L, userLoginRequest.getClientId(), 0);
		} else {
			return util.responseBuilder(0L, userLoginRequest.getClientId(), 23);
		}
	}

}
