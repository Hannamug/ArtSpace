package com.example.demo.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.user.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public void insert(UserDTO userDTO) {
		sqlSession.insert("user.insert", userDTO);
	}
	
}