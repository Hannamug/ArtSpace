package com.example.demo.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mypage.dao.MypageDAO;
import com.example.demo.mypage.dto.PerformerDTO;
import com.example.demo.user.dto.UserDTO;

@Service
public class MypageServiceImpl implements MypageService{

	@Autowired
	MypageDAO mypageDAO;
	

	@Override
	public UserDTO findByID(Integer id) {
		// TODO Auto-generated method stub
			return mypageDAO.findById(id);
	}

	@Override
	public void updateNickname(UserDTO dto, Integer id) {
		dto.setUser_id(id);
		mypageDAO.updateNickname(dto);
		
	}

	@Override
	public void updatePw(UserDTO dto, Integer id) {
		dto.setUser_id(id);
		mypageDAO.updatePw(dto);
		
	}

	@Override
	public PerformerDTO findByPID(Integer id) {
		
		return mypageDAO.findByPID(id);
	}

	@Override
	public void insert(PerformerDTO dto) {
		
		PerformerDTO existPerformer = mypageDAO.findByPID(dto.getUser_id());
		if (existPerformer == null) {
			mypageDAO.insertPerformer(dto);
		} else {
			mypageDAO.updatePerformer(dto);
		}
	}

	
}
