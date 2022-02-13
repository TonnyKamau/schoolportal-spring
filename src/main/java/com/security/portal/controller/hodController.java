package com.security.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.portal.models.AllocatedRoom;
import com.security.portal.models.SitAllocation;
import com.security.portal.service.AllocatedRoomService;
import com.security.portal.service.SitAllocationService;


@Controller
public class hodController {

	@Autowired
    private AllocatedRoomService alloservice;
	@Autowired
    private SitAllocationService sitservice;

    @GetMapping("/hod/timetable")
    public String viewTimetablePage(Model model,Authentication authentication) {
        List<AllocatedRoom> timetable = alloservice.listAll();
        model.addAttribute("timetable", timetable);	
    	model.addAttribute("userx", authentication.getName());
        return "HOD/index";
    }
    @GetMapping("/hod/sitallocations")
    public String viewSitPage(Model model) {
        List<SitAllocation> allocation = sitservice.listAll();
        model.addAttribute("allocation", allocation);	
        return "HOD/sitallocation";
    }

 

  
}
