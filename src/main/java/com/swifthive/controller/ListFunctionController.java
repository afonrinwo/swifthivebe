package com.swifthive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swifthive.manager.ClientLog;
import com.swifthive.manager.NavigationParam;
import com.swifthive.manager.UserFunction;
import com.swifthive.manager.UserRole;
import com.swifthive.manager.UserMenu;
import com.swifthive.manager.UserProfile;
import com.swifthive.model.ResponseCode;
import com.swifthive.model.function.FunctionObject;
import com.swifthive.model.menu.NavigationParamObject;
import com.swifthive.model.menu.MapMenuObject;
import com.swifthive.model.menu.MenuObject;
import com.swifthive.model.profile.ProfileObject;
import com.swifthive.model.role.RoleObject;
import com.swifthive.utilities.Util;

@RestController
public class ListFunctionController {
	
	@Autowired
	NavigationParam navigationParam;
	
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

	@RequestMapping(value = "/listFunction", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunction() {
		return userFunction.processListFunction();
	}

	@RequestMapping(value = "/listFunctionAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<FunctionObject> listFunctionAPL() {
		String status = "0";
		return userFunction.processListFunctionAPL(status);
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

	@RequestMapping(value = "/listMenu", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenu() {
		return userMenu.processListMenu();
	}

	@RequestMapping(value = "/listMenuAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<MenuObject> listMenuAPL() {
		String status = "0";
		return userMenu.processListMenuAPL(status);
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
	
	@RequestMapping(value = "/listNavigationParamAPL", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<NavigationParamObject> listNavigationParamAPL() {
		String status = "0";
		return navigationParam.processNavigationParamAPL(status);
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
	
}
