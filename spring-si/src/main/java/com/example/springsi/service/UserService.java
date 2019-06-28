package com.example.springsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsi.dao.UserDao;
import com.example.springsi.model.User;


// 시스템 기능(요구사항)을 표현(작성)

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	// 사용자 가입, 등록 
	public User registUser(User user) {
		userDao.insertUser(user);
		return user;
		
	}
	
	// 전체 사용자 조회
	public List<User> searchAllUsers() {
		return userDao.selectAllUsers();
	}
	
	// 사용자 아이디 조회
	public User searchUserByUserID(Integer userid) {
		//userDao.selectUserByKey(userid); 
		System.out.println(userid);
		return userDao.selectUserByKey(userid); 
	}
	
	
	// 사용자 정보 수정
	public User modifyUserInfo(User user) {
		System.out.println(user);
		return userDao.updateUser(user);
		
	}
	
		
	// 사용자 탈퇴/삭제
	public User removeUser(Integer userid) {
		//userDao.deleteUser(userid); 
		return userDao.deleteUser(userid);
		
	}
	
	
}
