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
import com.swifthive.model.userrole.CreateRoleRequest;
import com.swifthive.model.userrole.UserRoleObject;
import com.swifthive.repository.UserRoleRepository;

@Service
@Transactional
public class UserRole {

	private static final Logger logger = LogManager.getLogger(UserRole.class);
	private UserRoleObject userRoleObject;
	private Iterable<UserRoleObject> iUserRoleObject;
	private StringBuilder stringBuilder;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	Response response;
	
	@Autowired
	ResponseCode responseCode;

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
			if (userRoleRepository.existsById(userRoleObject.getRoleName())) {
				response.setUniqueId(0L);
				response.setResponseCode(String.format("%03d", 7));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[7]).toString());
			} else {
				userRoleRepository.save(userRoleObject);
				response.setUniqueId(userRoleObject.getUniqueId());
				response.setResponseCode(String.format("%03d", 0));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[0]).toString());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			response.setUniqueId(null);
			response.setResponseCode(String.format("%03d", 99));
			response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[99]).toString());
		}

		response.setClientId(createRoleRequest.getClientId());
		return response;
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

}
