package com.security.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.portal.models.AllocatedRoom;
import com.security.portal.models.Results;
import com.security.portal.service.AllocatedRoomService;
import com.security.portal.service.ResultsService;


@Controller
public class StudentController {
	@Autowired
    private AllocatedRoomService alloservice;
	@Autowired
    private ResultsService service;

    @GetMapping("/student/home")
    public String viewStudentWelcomePage(Model model) {
        List<Results> result = service.listAll();
        model.addAttribute("result", result);	
        return "std/home";
    }
    @GetMapping("/student/examination")
    public String viewStudentExamPage(Model model) {
        List<AllocatedRoom> timetable = alloservice.listAll();
        model.addAttribute("timetable", timetable);	
        return "std/results";
    }
    @GetMapping("/student/about")
    public String viewDeveloperAboutPage(Model model) {
        List<AllocatedRoom> timetable = alloservice.listAll();
        model.addAttribute("timetable", timetable);	
        return "std/contact";
    }
}
