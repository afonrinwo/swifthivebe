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
import com.swifthive.model.menu.ListMapMenuRequest;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.profile.NavAccessRightRequest;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.role.RoleObject;
import com.swifthive.utilities.Util;

@RestController
public class ListFunctionController {
	
	private Iterable<MenuObject> iMenuObject;
	
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

	@RequestMapping(value = "/viewFunction", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> viewFunction() {
		return userFunction.processListFunction();
	}

	@RequestMapping(value = "/listFunctionAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunctionAPL() {
		return userFunction.processListFunctionAPL(0);
	}

	@RequestMapping(value = "/viewRole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<RoleObject> viewRole() {
		return userRole.processListRole();
	}

	@RequestMapping(value = "/listRoleAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<RoleObject> listRoleAPL() {
		return userRole.processListRoleAPL(0);
	}

	@RequestMapping(value = "/viewMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> viewMenu() {
		return userMenu.processListMenu();
	}

	@RequestMapping(value = "/listMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenuAPL() {
		return userMenu.processListMenuAPL(0);
	}

	@RequestMapping(value = "/viewMapMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> viewMapMenu() {
		return userMenu.processListMapMenu();
	}
	
	
	@RequestMapping(value = "/listMapMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MapMenuObject> listMenuMappingAPL() {
		return userMenu.processMapMenuAPL(0);
	}
	
	
	@RequestMapping(value = "viewUserProfile", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> viewUserProfile() {
		return userProfile.processUserProfile();
	}
	
	@RequestMapping(value = "/listUserProfileAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProfileObject> listUserProfileAPL() {
		return userProfile.processUserProfileAPL(0);
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
		if (request.getHeader("Authorization").equals(
				util.accessValidation(listMapMenuRequest.getUserName() + listMapMenuRequest.getClientId()))) {
			return userMenu.processListMapMenu(listMapMenuRequest);
		} else {
			iMenuObject = new ArrayList<>();
			iMenuObject.forEach(null);
			return iMenuObject;
		}
	}
}
