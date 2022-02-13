package com.security.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.security.portal.models.Department;
import com.security.portal.models.User;
import com.security.portal.repository.AllocatedRoomRepository;
import com.security.portal.repository.DepartmentRepository;
import com.security.portal.repository.ResultsRepository;
import com.security.portal.repository.RoomRepository;
import com.security.portal.repository.UnitRepository;
import com.security.portal.repository.UserRepository;
import com.security.portal.service.DepartmentService;
import com.security.portal.service.UserService;


@Controller
public class UserController {
	 @Autowired
	    private UserRepository repo;
	 @Autowired
	    private DepartmentRepository drepo;
	 @Autowired
	    private AllocatedRoomRepository arrrepo;
	 @Autowired
	    private ResultsRepository rsrepo;
	 @Autowired
	    private UnitRepository urepo;
	 @Autowired
	    private RoomRepository rrepo;
	 @Autowired
	    private UserService service;
	 @Autowired
	    private DepartmentService departmentservice;
	 @GetMapping("/admin")
	    public String adminPanel(Model model, Authentication authentication) {
		 model.addAttribute("countUsers", repo.countUsers());
		 model.addAttribute("countDepartments", drepo.countDepartments());
		 model.addAttribute("countRoomAllocations", arrrepo.countRoomAllocations());
		 model.addAttribute("countRooms", rrepo.countRooms());
		 model.addAttribute("countCourseunits", urepo.countCourseunits());
		 model.addAttribute("countResults", rsrepo.countResults());
		 model.addAttribute("userx", authentication.getName());
	        return "admin/index";
	    }
	    @GetMapping("/admin/usersview")
	    public String viewHomePage(Model model) {
	        List<User> listuser = service.listAll();
	        model.addAttribute("listuser", listuser);	
	        return "admin/Uview";
	    }

	    @GetMapping("/admin/users")
	    public String add(Model model) {
	        model.addAttribute("users", new User());
	        List<Department> listdepartment = departmentservice.listAll();
	        model.addAttribute("listdepartment", listdepartment);
	        return "admin/users";
	    }

	    @RequestMapping(value = "/admin/users/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("users") User std) {
	        service.save(std);
	        return "redirect:/admin/usersview";
	    }

	    @RequestMapping("/useredit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("admin/edituser");
	        User std = service.get(id);
	        mav.addObject("users", std);
	        return mav;
	        
	    }
	    @RequestMapping("/userdelete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/admin/usersview";
	    }
}