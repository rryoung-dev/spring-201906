package com.example.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springsi.model.User;
 
// Datasource 외부데이터

@Repository
public class UserDao {
	
	private static String NAME_SPACE = "com.example.springsi.dao.UserDao.";
	@Autowired
	private SqlSession sqlSession;

	public List<User> selectAllUsers() {
		
//		List<User> userList = new ArrayList<>();
//		userList.add(new User(1, "kim", 30));
//		userList.add(new User(2, "Lee", 35));
//		userList.add(new User(3, "Choi", 40));
//		userList.add(new User(4, "Park", 20));
//		userList.add(new User(5, "Kang", 25));
//		
//		return userList;
		
		String statement = NAME_SPACE + "selectAllUsers"; 
		return sqlSession.selectList(statement);
	}
	
	public User selectUserByKey(Integer userid) {

		// mapper xml에 정의한 query 문 이름으로 sql을 넘겨줘야 함 
		String statement = NAME_SPACE + "selectUserByKey"; 
		return sqlSession.selectOne(statement, userid);
		
	}
	   
	public User insertUser(User user) {
		
		String statement = NAME_SPACE + "insertUser"; 
		sqlSession.insert(statement, user);
		System.out.println("[Dao] insert ok..");
		return user;
	}
	
	public User updateUser(User user) {
		
		String statement = NAME_SPACE + "updateUser"; 
		sqlSession.update(statement, user);
		System.out.println("[Dao] update ok..");
		return user;
	}
	
	public User deleteUser(Integer userid) {
		
		String statement = NAME_SPACE + "deleteUser";
		sqlSession.delete(statement, userid);
		System.out.println("[Dao] delete ok..");
		return null;
	}
}
