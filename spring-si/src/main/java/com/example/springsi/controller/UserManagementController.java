package com.example.springsi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springsi.model.User;
import com.example.springsi.service.UserService;

@Controller
@ResponseBody
public class UserManagementController {
	
	private static Logger log = LoggerFactory.getLogger(UserManagementController.class);
	
	//controller는 항상 service를 포함하고 있음
	@Autowired
	private UserService userService;
	
	/*
	
	 /users [GET] : 사용자 전체 보기 List<User> searchUsers
	 /users/3 [GET] : 사용자 상세 보기 User searchUserByUserid(userid)
	 /users [POST] : 사용자 등록 User registUser(User)
	 /users/3 [PUT] : 사용자 수정 User modifyUser(User)
	 /users/3 [DELETE] : 사용자 삭제 User removeUser(userid)

	 */
	
	@GetMapping("/users")
	public Map<String,Object> searchUsers() {
		
		List<User> listOfUser = userService.searchAllUsers();
		Map<String,Object> result = new HashMap<>();
		result.put("status", true);
		result.put("datetime", new Date() );
		result.put("data", listOfUser);
		
		return result;
		//return userService.searchAllUsers();	
	}
	
	@GetMapping("/users/{userid}")
	public User searchUserByUserid(@PathVariable Integer userid) {
		log.debug("" + userid);
		return userService.searchUserByUserID(userid);
	}
	
	@PostMapping("/users/")
	public User registUser(@RequestBody User user) {
		
		// user 확보 방법 1.html form방식 2.data json
		System.out.println(user);
		return userService.registUser(user);
		
	}
	
	@PutMapping("/users/{userid}")
	public User modifyUser (@RequestBody User user) {
		return userService.modifyUserInfo(user);
	}
	
	
	@DeleteMapping("/users/{userid}")
	public User removeUser (@PathVariable Integer userid) {
		log.debug("******delete userid : " + userid);
		return userService.removeUser(userid);
	}
	
	
	
}
