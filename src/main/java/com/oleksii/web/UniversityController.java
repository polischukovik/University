package com.oleksii.web;

import com.oleksii.data.service.GroupService;
import com.oleksii.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UniversityController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private StudentService studentService;

	@GetMapping("students")
	public String getStudents(Model model){
		model.addAttribute("students", studentService.findAll());
		return "student_summary";
	}

	@GetMapping("student")
	public String getStudent(){
		return "student_details";
	}
}
