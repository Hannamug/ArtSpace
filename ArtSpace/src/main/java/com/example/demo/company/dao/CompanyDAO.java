package com.example.demo.company.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.hall.dto.HallDTO;

@Repository
public class CompanyDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public List<HallDTO> getHall(Integer user_id) {
		
		return sqlSession.selectList("company.getHall", user_id);
	}
	
	
}