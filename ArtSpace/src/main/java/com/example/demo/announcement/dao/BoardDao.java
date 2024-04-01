package com.example.demo.announcement.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.announcement.dto.BoardDto;
import com.example.demo.user.dto.UserDTO;

@Repository
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public void insert(BoardDto boardDto) {
		sqlSession.insert("user.insert", boardDto);
	}

	// 로그인 후 이름 뱉어내기
	public BoardDto login(BoardDto boardDto) {
		return sqlSession.selectOne("user.login", boardDto);
	}

	public int emailCheck(String email) {
		return sqlSession.selectOne("user.email_check", email);
	}

}