package com.whitetest.soap.data.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whitetest.soap.data.models.ExamsRequest;
import com.whitetest.soap.data.models.ExamsResponse;
import com.whitetest.soap.data.models.StudentRequest;
import com.whitetest.soap.data.models.WhiteTestResponse;
import com.whitetest.soap.data.services.WhiteTestService;

@Controller
@RequestMapping("/tekup")
public class WhiteTestController {
	@Autowired
	WhiteTestService service;
	
	
	@GetMapping("/checkWhiteTest")
	public String checkWhiteTest(Model model) {
		StudentRequest request = new StudentRequest();
		model.addAttribute("request", request);
		return "checkWhiteTest";

	}
	@PostMapping("/checkWhiteTest")
	public String checkWhiteTest(@ModelAttribute("request") StudentRequest request,Model model) {
		WhiteTestResponse whiteTest = service.checkWhiteTest(request);
		model.addAttribute("response",whiteTest);
		return "checkWhiteTestResponse";
		
	}
	@GetMapping("/allWhiteTests")
	public String getAllWhiteTests(Model model) {
	
		ExamsResponse exams=service.getAllWhiteTests(new ExamsRequest());
		model.addAttribute("exams",exams);
		
		return "exams";
	}
	
	
	

}
