package com.lms.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.bo.LeaveDetails;
import com.lms.demo.repository.LeaveManageRepository;

@Service
public class LeaveManageService {

	@Autowired
	private LeaveManageRepository leaveManageRepository;

	@SuppressWarnings("deprecation")
	public void applyLeave(LeaveDetails leaveDetails) {

		int duration = leaveDetails.getToDate().getDate() - leaveDetails.getFromDate().getDate();
		leaveDetails.setDuration(duration + 1);
		/* leaveDetails.setActive(true); */
		leaveManageRepository.save(leaveDetails);
	}

	public List<LeaveDetails> getAllLeaves() {

		return leaveManageRepository.findAll();
	}

	

	public void updateLeaveDetails(LeaveDetails leaveDetails) {

		leaveManageRepository.save(leaveDetails);

	}

}
