package com.whitetest.soap.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whitetest.soap.data.models.StudentsRequest;
import com.whitetest.soap.data.models.StudentsResponse;
import com.whitetest.soap.data.services.StudentService;

@Controller
@RequestMapping("/tekup")
public class StudentController {
	
	
	@Autowired
	
	StudentService service;
	
	@GetMapping("/allStudents")
	public String getAllStudents(Model model) {
	
		StudentsResponse students=service.getAllStudents(new StudentsRequest());
		model.addAttribute("students",students);
		
		return "students";
	}

}
