package com.example.springsi.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springsi.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsreDaoTests {
	// test suit
	// test 대상은 항상 method
	
	@Autowired
	private UserDao userDao;
	
	@Ignore	
	@Test
	public void testInsertUSer() {
		User user = new User(200, "스프링", 10);
		User returned = userDao.insertUser(user);

		Assert.assertTrue(returned.getUserid() == 200);
	}
	

	@Test
	public void testSelectAllUsers() {
		List<User> listOfUser = userDao.selectAllUsers();
		
		// List의 사이즈가 보다 크면성공, null이 아니면 성공
		Assert.assertNotNull(listOfUser);
		
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User(2,"추신수", 38);
		User result = userDao.updateUser(user);
		Assert.assertNotNull(result);
	}
}
