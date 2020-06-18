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
import com.swifthive.model.Response;
import com.swifthive.model.ResponseCode;
import com.swifthive.model.usermenu.CreateUserMenuRequest;
import com.swifthive.model.usermenu.UserMenuMappingRequest;
import com.swifthive.model.usermenu.UserMenuMappingObject;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.repository.UserMenuMappingRepository;
import com.swifthive.repository.UserMenuRepository;

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
	private StringBuilder stringBuilder;

	@Autowired
	UserMenuRepository userMenuRepository;

	@Autowired
	UserMenuMappingRepository userMenuMappingRepository;

	@Autowired
	Response response;

	@Autowired
	ResponseCode responseCode;

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
			if (userMenuRepository.existsById(userMenuObject.getMenuName())) {
				response.setUniqueId(0L);
				response.setResponseCode(String.format("%03d", 7));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[7]).toString());
			} else {
				userMenuRepository.save(userMenuObject);
				response.setUniqueId(userMenuObject.getUniqueId());
				response.setResponseCode(String.format("%03d", 0));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[0]).toString());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			response.setUniqueId(0L);
			response.setResponseCode(String.format("%03d", 99));
			response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[99]).toString());
		}

		response.setClientId(createUserMenuRequest.getClientId());
		return response;
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
			if (userMenuMappingRepository.existsByIds(userMenuMappingObject.getFunctionName() , userMenuMappingObject.getRoleName())) {
				response.setUniqueId(0L);
				response.setResponseCode(String.format("%03d", 7));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[7]).toString());
			} else {
				userMenuMappingRepository.save(userMenuMappingObject);
				response.setUniqueId(userMenuMappingObject.getUniqueId());
				response.setResponseCode(String.format("%03d", 99));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[0]).toString());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			response.setUniqueId(0L);
			response.setResponseCode(String.format("%03d", 99));
			response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[99]).toString());
		}
		response.setClientId(userMenuMappingRequest.getClientId());
		return response;
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

}
