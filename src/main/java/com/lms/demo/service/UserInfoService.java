package com.lms.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.bo.UserInfo;
import com.lms.demo.repository.UserInfoRepository;


@Service
public class UserInfoService {

	@Autowired
    private UserInfoRepository userInfoRepository;
	
	 	
	public UserInfo findUserByEmail(String email) {
		return userInfoRepository.findByEmail(email);
	    }

	    public void saveUser(UserInfo userInfo) {
		userInfo.setPassword(userInfo.getPassword());
		userInfo.setActive(false);
		userInfoRepository.save(userInfo);

	    }

	    public List<UserInfo> getUsers() {

		return userInfoRepository.findAllByOrderById();
	    }

	    public UserInfo getUserById(int id) {

		return userInfoRepository.findById(id);
	    }

	    public void deleteUser(int id) {
		userInfoRepository.deleteById(id);
	    }

	    public void blockUser(int id) {

		userInfoRepository.blockUser(id);

	    }

	    public void unBlockUser(int id) {

		userInfoRepository.unBlockUser(id);
	    }

}
