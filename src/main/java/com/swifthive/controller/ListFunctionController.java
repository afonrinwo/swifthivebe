package com.swifthive.controller;

import java.util.ArrayList;

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
import com.swifthive.model.ResponseCode;
import com.swifthive.model.function.FunctionObject;
import com.swifthive.model.function.FunctionRequest;
import com.swifthive.model.menu.ListMapMenuRequest;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MapMenuRequest;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.menu.MenuRequest;
import com.swifthive.model.profile.NavAccessRightRequest;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.profile.ProfileRequest;
import com.swifthive.model.role.RoleObject;
import com.swifthive.model.role.RoleRequest;
import com.swifthive.utilities.Util;

@RestController
public class ListFunctionController {

	private Iterable<MenuObject> iMenuObject;
	private Iterable<FunctionObject> iFunctionObject;
	private Iterable<RoleObject> iRoleObject;
	private Iterable<MapMenuObject> iMapMenuObject;
	private Iterable<ProfileObject> iProfileObject;

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

	@Autowired
	ResponseCode responseCode;

	@RequestMapping(value = "/viewFunction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> viewFunction(HttpServletRequest request,
			@Validated @RequestBody FunctionRequest functionRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(functionRequest.getUserName() + functionRequest.getClientId()))) {
			return userFunction.processListFunction(functionRequest.getMerchantId());
		} else {
			iFunctionObject = new ArrayList<>();
			iFunctionObject.forEach(null);
			return iFunctionObject;
		}
	}

	@RequestMapping(value = "/listFunctionAPL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunctionAPL(HttpServletRequest request,
			@Validated @RequestBody FunctionRequest functionRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(functionRequest.getUserName() + functionRequest.getClientId()))) {
			return userFunction.processListFunctionAPL(functionRequest.getMerchantId(), 0);
		} else {
			iFunctionObject = new ArrayList<>();
			iFunctionObject.forEach(null);
			return iFunctionObject;
		}
	}

	@RequestMapping(value = "/viewRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<RoleObject> viewRole(HttpServletRequest request,
			@Validated @RequestBody RoleRequest roleRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(roleRequest.getUserName() + roleRequest.getClientId()))) {
			return userRole.processListRole(roleRequest.getMerchantId());
		} else {
			iRoleObject = new ArrayList<>();
			iRoleObject.forEach(null);
			return iRoleObject;
		}
	}

	@RequestMapping(value = "/listRoleAPL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<RoleObject> listRoleAPL(HttpServletRequest request,
			@Validated @RequestBody RoleRequest roleRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(roleRequest.getUserName() + roleRequest.getClientId()))) {
			return userRole.processListRoleAPL(roleRequest.getMerchantId(), 0);
		} else {
			iRoleObject = new ArrayList<>();
			iRoleObject.forEach(null);
			return iRoleObject;
		}
	}

	@RequestMapping(value = "/viewMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MenuObject> viewMenu(HttpServletRequest request,
			@Validated @RequestBody MenuRequest menuRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(menuRequest.getUserName() + menuRequest.getClientId()))) {
			return userMenu.processListMenu(menuRequest.getMerchantId());
		} else {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
			return iMenuObject;
		}
	}

	@RequestMapping(value = "/listMenuAPL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenuAPL(HttpServletRequest request,
			@Validated @RequestBody MenuRequest menuRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(menuRequest.getUserName() + menuRequest.getClientId()))) {
			return userMenu.processListMenuAPL(menuRequest.getMerchantId(), 0);
		} else {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
			return iMenuObject;
		}
	}

	@RequestMapping(value = "/viewMapMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> viewMapMenu(HttpServletRequest request,
			@Validated @RequestBody MapMenuRequest mapMenuRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(mapMenuRequest.getUserName() + mapMenuRequest.getClientId()))) {
			return userMenu.processListMapMenu(mapMenuRequest.getMerchantId());
		} else {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject.forEach(null);
			return iMapMenuObject;
		}
	}

	@RequestMapping(value = "/listMapMenuAPL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> listMenuMappingAPL(HttpServletRequest request,
			@Validated @RequestBody MapMenuRequest mapMenuRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(mapMenuRequest.getUserName() + mapMenuRequest.getClientId()))) {
			return userMenu.processMapMenuAPL(mapMenuRequest.getMerchantId(), 0);
		} else {
			iMapMenuObject = new ArrayList<>();
			iMapMenuObject.forEach(null);
			return iMapMenuObject;
		}
	}

	@RequestMapping(value = "viewUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> viewUserProfile(HttpServletRequest request,
			@Validated @RequestBody ProfileRequest profileRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(profileRequest.getUserName() + profileRequest.getClientId()))) {
			return userProfile.processUserProfile(profileRequest.getMerchantId());
		} else {
			iProfileObject = new ArrayList<>();
			iProfileObject.forEach(null);
			return iProfileObject;
		}
	}

	@RequestMapping(value = "/listUserProfileAPL", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> listUserProfileAPL(HttpServletRequest request,
			@Validated @RequestBody ProfileRequest profileRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(profileRequest.getUserName() + profileRequest.getClientId()))) {
			return userProfile.processUserProfileAPL(profileRequest.getMerchantId(), 0);
		} else {
			iProfileObject = new ArrayList<>();
			iProfileObject.forEach(null);
			return iProfileObject;
		}
	}

	@RequestMapping(value = "/navAccessRight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MenuObject> navAccessRight(HttpServletRequest request,
			@Validated @RequestBody NavAccessRightRequest navAccessRightRequest) {
		if (request.getHeader("Authorization").equals(
				util.accessValidation(navAccessRightRequest.getUserName() + navAccessRightRequest.getClientId()))) {
			return userProfile.processNavAccessRight(navAccessRightRequest);
		} else {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
			return iMenuObject;
		}
	}

	@RequestMapping(value = "/listMapMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMapMenu(HttpServletRequest request,
			@Validated @RequestBody ListMapMenuRequest listMapMenuRequest) {
		if (request.getHeader("Authorization")
				.equals(util.accessValidation(listMapMenuRequest.getUserName() + listMapMenuRequest.getClientId()))) {
			return userMenu.processListMapMenu(listMapMenuRequest);
		} else {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
			return iMenuObject;
		}
	}
}
