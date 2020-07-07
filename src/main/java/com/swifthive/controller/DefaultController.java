package com.swifthive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swifthive.manager.ClientLog;
import com.swifthive.manager.UserFunction;
import com.swifthive.manager.UserRole;
import com.swifthive.manager.UserMenu;
import com.swifthive.manager.UserProfile;
import com.swifthive.model.ClientLogRequest;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.function.FunctionRequest;
import com.swifthive.model.function.FunctionObject;
import com.swifthive.model.menu.MenuRequest;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MapMenuRequest;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.profile.CreateProfileRequest;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.profile.UserLoginRequest;
import com.swifthive.model.role.RoleRequest;
import com.swifthive.model.role.RoleObject;
import com.swifthive.utilities.Util;

@RestController
public class DefaultController {
	
	@Autowired
	UserProfile userProfile;

	@Autowired
	UserFunction userFunction;

	@Autowired
	UserRole userRole;

	@Autowired
	UserMenu userMenu;

	@Autowired
	ClientLog clientLog;

	@Autowired
	Util util;

	// Display Start Page
	@RequestMapping("/")
	public @ResponseBody String displayStartPage() {
		return "Welcome to SwiftHive";
	}

	@RequestMapping(value = "/clientLog", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody void clientLog(HttpServletRequest request,
			@Validated @RequestBody ClientLogRequest clientLogRequest) {
		clientLog.processClientLog(clientLogRequest);
	}

	@RequestMapping(value = "/createFunction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createFunction(HttpServletRequest request,
			@Validated @RequestBody FunctionRequest functionRequest) {
		if (request.getHeader("Authorization").equals(util
				.accessValidation(functionRequest.getUserId() + functionRequest.getClientId()))) {
			return userFunction.processCreateFunction(functionRequest);
		} else {
			return util.responseBuilder(0L, functionRequest.getClientId(), 96);
		}

	}

	@RequestMapping(value = "/listFunction", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunction() {
		return userFunction.processListFunction();
	}

	@RequestMapping(value = "/listFunctionAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunctionAPL() {
		String status = "0";
		return userFunction.processListFunctionAPL(status);
	}

	@RequestMapping(value = "/createRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createRole(HttpServletRequest request,
			@Validated @RequestBody RoleRequest roleRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(roleRequest.getUserId() + roleRequest.getClientId()))) {
			return userRole.processCreateRole(roleRequest);
		} else {
			return util.responseBuilder(0L, roleRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listRole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<RoleObject> listRole() {
		return userRole.processListRole();
	}

	@RequestMapping(value = "/listRoleAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<RoleObject> listRoleAPL() {
		String status = "0";
		return userRole.processListRoleAPL(status);
	}

	@RequestMapping(value = "/createMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createMenu(HttpServletRequest request,
			@Validated @RequestBody MenuRequest menuRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(menuRequest.getUserId() + menuRequest.getClientId()))) {
			return userMenu.processCreateMenu(menuRequest);
		} else {
			return util.responseBuilder(0L, menuRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenu() {
		return userMenu.processListMenu();
	}

	@RequestMapping(value = "/listMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenuAPL() {
		String status = "0";
		return userMenu.processListMenuAPL(status);
	}

	@RequestMapping(value = "/mapMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response mapMenu(HttpServletRequest request,
			@Validated @RequestBody MapMenuRequest mapMenuRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(mapMenuRequest.getUserId() + mapMenuRequest.getClientId()))) {
			return userMenu.processMapMenu(mapMenuRequest);
		} else {
			return util.responseBuilder(0L, mapMenuRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listMapMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> listMapMenu() {
		return userMenu.processListMapMenu();
	}
	
	@RequestMapping(value = "/listMapMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> listMenuMappingAPL() {
		String status = "0";
		return userMenu.processMapMenuAPL(status);
	}

	@RequestMapping(value = "/pendingAuthorization", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response pendingAuthorization(HttpServletRequest request,
			@Validated @RequestBody PendingAuthorizationRequest pendingAuthorizationRequest) {
		if (request.getHeader("Authorization").equals(util.accessValidation(
				pendingAuthorizationRequest.getUserId() + pendingAuthorizationRequest.getClientId()))) {
			switch (pendingAuthorizationRequest.getActionCall()) {
			case "UserFunction":
				return userFunction.processPendingAuthorization(pendingAuthorizationRequest);
			case "UserRole":
				return userRole.processPendingAuthorization(pendingAuthorizationRequest);
			case "UserMenu":
				return userMenu.processPendingAuthorization(pendingAuthorizationRequest);
			case "MapMenu":
				return userMenu.processPendingAuthorization(pendingAuthorizationRequest);
			case "UserProfile":
				return userProfile.processPendingAuthorization(pendingAuthorizationRequest);
			default:
				return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 95);
			}
		} else {
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 96);
		}

	}
	
	@RequestMapping(value = "/createProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createProfile(HttpServletRequest request,
			@Validated @RequestBody CreateProfileRequest createProfileRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(createProfileRequest.getUserId() + createProfileRequest.getClientId()))) {
			return userProfile.processCreateUserProfile(createProfileRequest);
		} else {
			return util.responseBuilder(0L, createProfileRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "listUserProfile", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> listProfile() {
		return userProfile.processUserProfile();
	}
	
	@RequestMapping(value = "/listUserProfileAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> listUserProfileAPL() {
		String status = "0";
		return userProfile.processUserProfileAPL(status);
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response userLogin(HttpServletRequest request,
			@Validated @RequestBody UserLoginRequest userLoginRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(userLoginRequest.getUserName() + userLoginRequest.getClientId()))) {
			return userProfile.processUserLogin(userLoginRequest);
		} else {
			return util.responseBuilder(0L, userLoginRequest.getClientId(), 96);
		}
	}
}
