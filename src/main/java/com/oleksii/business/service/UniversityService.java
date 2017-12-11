package com.oleksii.business.service;

import com.oleksii.data.service.GroupService;
import com.oleksii.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class UniversityService {

	@Autowired
	private GroupService groupService;

	@Autowired
	private StudentService studentService;

	public UniversityService(GroupService groupService, StudentService studentService) {
		this.groupService = groupService;
		this.studentService = studentService;
	}
}
