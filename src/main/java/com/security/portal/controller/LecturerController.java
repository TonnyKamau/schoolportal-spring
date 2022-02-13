package com.security.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.portal.models.AllocatedRoom;
import com.security.portal.models.Results;
import com.security.portal.service.AllocatedRoomService;
import com.security.portal.service.ResultsService;




@Controller
public class LecturerController {

	@Autowired
    private AllocatedRoomService alloservice;
	@Autowired
    private ResultsService service;

    @GetMapping("/lecturer/results")
    public String viewResultsPage(Model model,Authentication authentication) {
        List<Results> result = service.listAll();
        model.addAttribute("result", result);
        model.addAttribute("userx", authentication.getName());
        return "lec/index";
    }
    @GetMapping("/lecturer/timetable")
    public String viewTimetablePage(Model model) {
        List<AllocatedRoom> timetable = alloservice.listAll();
        model.addAttribute("timetable", timetable);	
        return "lec/timetable";
    }
  
}
