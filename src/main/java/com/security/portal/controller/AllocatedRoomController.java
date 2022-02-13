package com.security.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.portal.models.AllocatedRoom;
import com.security.portal.models.Room;
import com.security.portal.models.Unit;
import com.security.portal.service.AllocatedRoomService;
import com.security.portal.service.RoomService;
import com.security.portal.service.UnitService;




@Controller
public class AllocatedRoomController {
	 @Autowired
	    private RoomService roomservice;
	 @Autowired
	    private UnitService unitsservice;
	 @Autowired
	    private AllocatedRoomService service;

	    @GetMapping("/admin/roomallocationview")
	    public String viewHomePage(Model model) {
	        List<AllocatedRoom> listallocatedroom = service.listAll();
	        model.addAttribute("listallocatedroom", listallocatedroom);	
	        return "admin/ARview";
	    }

	    @GetMapping("/admin/roomallocation")
	    public String addallocatedRoom(Model model) {
	        model.addAttribute("allocatedRoom", new AllocatedRoom());
	        List<Room> listrooms = roomservice.listAll();
	        model.addAttribute("listrooms", listrooms);
	        List<Unit> listunit = unitsservice.listAll();
	        model.addAttribute("listunit", listunit);	
	        return "admin/roomallocation";
	    }

	    @RequestMapping(value = "/admin/roomallocations/save", method = RequestMethod.POST)
	    public String saveallocatedRoom(@ModelAttribute("allocatedRoom") AllocatedRoom std) {
	        service.save(std);
	        return "redirect:/admin/roomallocationview";
	    }

	    @RequestMapping("/editAllocatedRoom/{id}")
	    public ModelAndView showEditAllocatedRoomPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("admin/editroomallocation");
	        AllocatedRoom std = service.get(id);
	        mav.addObject("allocatedRoom", std);
	        return mav;
	        
	    }
	    @RequestMapping("/deleteAllocatedRoom/{id}")
	    public String deleteAlloRoom(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/admin/roomallocationview";
	    }
}
