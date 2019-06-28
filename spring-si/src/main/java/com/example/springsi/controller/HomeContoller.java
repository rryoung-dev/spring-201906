package com.example.springsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springsi.model.User;
import com.example.springsi.service.UserService;

@Controller
public class HomeContoller {
	
	// member 변수로 잡아서 사용하는것 - composition 
	@Autowired
	private UserService userService; 
	
	
	@GetMapping("/greet")
	@ResponseBody
	public String hello() {
		return "Hello World..";
	}

//	@GetMapping("/users/1") 
//	@ResponseBody
//	public User searchUserByUserid() {
//		
//		// userService = new UserService(); // heap 영역에 올라와서 method가 끝나면 delete 해줘야 함
//		// Spring에서 component를 관리하도록 하려면 dependency injection 하도록 autowired anotation을 걸어줌 
//		
//		// User user = new User(3, "김순곤", 40);
//		Integer userid = 3;
//		User user = userService.searchUserByUserID(userid);
//		
//		return user;
//	}
	
}
