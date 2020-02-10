package com.lms.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.demo.bo.LeaveDetails;
import com.lms.demo.bo.UserInfo;
import com.lms.demo.service.LeaveManageService;
import com.lms.demo.service.UserInfoService;

@RestController
@RequestMapping("/api")
public class LeaveManageController {

	@Autowired
	private LeaveManageService leaveManageService;

	@Autowired
	private UserInfoService userInfoService;
	@PostMapping("/applyLeave")
	public String applyLeave(@RequestBody @Valid LeaveDetails leaveDetails) {
		System.out.println("simha....");
		UserInfo userInfo = new UserInfo();
		leaveDetails.setUsername(userInfo.getEmail());
	    leaveDetails.setEmployeeName(userInfo.getFirstName() + " " + userInfo.getLastName());
	    leaveManageService.applyLeave(leaveDetails);
	return "leave applied sucessfully";
	}

}
