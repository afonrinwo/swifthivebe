package com.swifthive.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swifthive.manager.UserFunction;
import com.swifthive.manager.UserRole;
import com.swifthive.manager.UserMenu;
import com.swifthive.model.Response;
import com.swifthive.model.createMenu.CreateMenuRequest;
import com.swifthive.model.userRole.CreateRoleRequest;
import com.swifthive.model.userRole.UserRoleObject;
import com.swifthive.model.userfunction.CreateUserFunctionRequest;
import com.swifthive.model.userfunction.UserFunctionObject;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DefaultController {
	
	@Autowired UserFunction userFunction;
	
	@Autowired UserRole userRole;
	
	@Autowired UserMenu userMenu;
	
	// Display Start Page
	@RequestMapping("/")
	public @ResponseBody String displayStartPage() {
		return "Welcome to SwiftHive";
	}

	@RequestMapping(value = "/createUserFunction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createUserFunction(@Valid @RequestBody CreateUserFunctionRequest createUserFunctionRequest) {
		return userFunction.processCreateUserFunction(createUserFunctionRequest);
	}
	
	@RequestMapping(value = "/listUserFunction", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserFunctionObject> listUserFunction() {
		return userFunction.processListUserFunction();
	}
	
	@RequestMapping(value = "/userRole", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createRole(@Valid @RequestBody CreateRoleRequest createRoleRequest) {
		return userRole.processCreateRole(createRoleRequest);
	}	
	
	@RequestMapping(value = "/listUserRole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<UserRoleObject> listUserRole() {
		return userRole.processListUserRole();
	}
	
	@RequestMapping(value = "/userMenu", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createMenu(@Valid @RequestBody CreateMenuRequest createMenuRequest) {
		return userMenu.processCreateMenu(createMenuRequest);
	}
}
