package com.swifthive.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swifthive.model.Response;
import com.swifthive.model.ResponseCode;
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.repository.UserFunctionRepository;
import com.swifthive.model.userfunction.CreateUserFunctionRequest;

@Service
@Transactional
public class UserFunction {

	private static final Logger logger = LogManager.getLogger(UserFunction.class);
	private UserFunctionObject userFunctionObject;
	private Iterable<UserFunctionObject> iUserFunctionObject;
	private StringBuilder stringBuilder;

	@Autowired
	UserFunctionRepository userFunctionRepository;

	@Autowired
	Response response;

	@Autowired
	ResponseCode responseCode;

	public Response processCreateUserFunction(@Valid CreateUserFunctionRequest createUserFunctionRequest) {

		stringBuilder = new StringBuilder();
		try {
			// execute your business logic here, persist function information
			userFunctionObject = new UserFunctionObject();
			userFunctionObject.setClientId(createUserFunctionRequest.getClientId());
			userFunctionObject.setFunctionName(createUserFunctionRequest.getFunctionName());
			userFunctionObject.setCreatedBy(createUserFunctionRequest.getUserId());
			userFunctionObject.setStatus("0");
			userFunctionObject.setDateCreated(LocalDateTime.now());
			if (userFunctionRepository.existsById(userFunctionObject.getFunctionName())) {
				response.setUniqueId(0L);
				response.setResponseCode(String.format("%03d", 7));
				response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[7]).toString());
			} else {
				userFunctionRepository.save(userFunctionObject);
				response.setUniqueId(userFunctionObject.getUniqueId());
				response.setResponseCode(String.format("%03d", 0));
				response.setResponseMessage("Successful");
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			response.setUniqueId(0L);
			response.setResponseCode(String.format("%03d", 99));
			response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[99]).toString());
		}
		
		response.setClientId(createUserFunctionRequest.getClientId());
		return response;
	}

	public Iterable<UserFunctionObject> processListUserFunction() {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = userFunctionRepository.findAll();
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}
		return iUserFunctionObject;
	}

	public Iterable<UserFunctionObject> processListUserFunctionAPL(String status) {
		try {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject = userFunctionRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserFunctionObject = new ArrayList<>();
			iUserFunctionObject.forEach(null);
		}

		return iUserFunctionObject;
	}
}
