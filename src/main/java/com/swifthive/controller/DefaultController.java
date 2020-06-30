package com.swifthive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swifthive.manager.ClientLog;
import com.swifthive.manager.UserFunction;
import com.swifthive.manager.UserRole;
import com.swifthive.manager.UserMenu;
import com.swifthive.model.ClientLogRequest;
import com.swifthive.model.PendingAuthorizationRequest;
import com.swifthive.model.Response;
import com.swifthive.model.userfunction.CreateUserFunctionRequest;
import com.swifthive.model.userfunction.UserFunctionObject;
import com.swifthive.model.usermenu.CreateUserMenuRequest;
import com.swifthive.model.usermenu.UserMenuMappingObject;
import com.swifthive.model.usermenu.UserMenuMappingRequest;
import com.swifthive.model.usermenu.UserMenuObject;
import com.swifthive.model.userrole.CreateRoleRequest;
import com.swifthive.model.userrole.UserRoleObject;
import com.swifthive.utilities.Util;

@RestController
public class DefaultController {

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
			@Valid @RequestBody ClientLogRequest clientLogRequest) {
		clientLog.processClientLog(clientLogRequest);
	}

	@RequestMapping(value = "/createUserFunction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createUserFunction(HttpServletRequest request,
			@Valid @RequestBody CreateUserFunctionRequest createUserFunctionRequest) {
		if (request.getHeader("Authorization").equals(util
				.accessValidation(createUserFunctionRequest.getUserId() + createUserFunctionRequest.getClientId()))) {
			return userFunction.processCreateUserFunction(createUserFunctionRequest);
		} else {
			return util.responseBuilder(0L, createUserFunctionRequest.getClientId(), 96);
		}

	}

	@RequestMapping(value = "/listUserFunction", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserFunctionObject> listUserFunction() {
		return userFunction.processListUserFunction();
	}

	@RequestMapping(value = "/listUserFunctionAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserFunctionObject> listUserFunctionAPL() {
		String status = "0";
		return userFunction.processListUserFunctionAPL(status);
	}

	@RequestMapping(value = "/createUserRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createRole(HttpServletRequest request,
			@Valid @RequestBody CreateRoleRequest createRoleRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(createRoleRequest.getUserId() + createRoleRequest.getClientId()))) {
			return userRole.processCreateRole(createRoleRequest);
		} else {
			return util.responseBuilder(0L, createRoleRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listUserRole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserRoleObject> listUserRole() {
		return userRole.processListUserRole();
	}

	@RequestMapping(value = "/listUserRoleAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserRoleObject> listUserRoleAPL() {
		String status = "0";
		return userRole.processListUserRoleAPL(status);
	}

	@RequestMapping(value = "/createUserMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createMenu(HttpServletRequest request,
			@Valid @RequestBody CreateUserMenuRequest createUserMenuRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(createUserMenuRequest.getUserId() + createUserMenuRequest.getClientId()))) {
			return userMenu.processCreateMenu(createUserMenuRequest);
		} else {
			return util.responseBuilder(0L, createUserMenuRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listUserMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserMenuObject> listUserMenu() {
		return userMenu.processListUserMenu();
	}

	@RequestMapping(value = "/listUserMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserMenuObject> listUserMenuAPL() {
		String status = "0";
		return userMenu.processListUserMenuAPL(status);
	}

	@RequestMapping(value = "/menuMapping", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response menuMapping(HttpServletRequest request,
			@Valid @RequestBody UserMenuMappingRequest userMenuMappingRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(userMenuMappingRequest.getUserId() + userMenuMappingRequest.getClientId()))) {
			return userMenu.processMenuMapping(userMenuMappingRequest);
		} else {
			return util.responseBuilder(0L, userMenuMappingRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/listMenuMappingAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserMenuMappingObject> listMenuMappingAPL() {
		String status = "0";
		return userMenu.processMenuMappingAPL(status);
	}

	@RequestMapping(value = "/pendingAuthorization", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response pendingAuthorization(HttpServletRequest request,
			@Valid @RequestBody PendingAuthorizationRequest pendingAuthorizationRequest) {
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
			default:
				return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 95);
			}
		} else {
			return util.responseBuilder(0L, pendingAuthorizationRequest.getClientId(), 96);
		}

	}
}
