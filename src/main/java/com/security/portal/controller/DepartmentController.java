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

import com.security.portal.models.Department;
import com.security.portal.service.DepartmentService;




@Controller
public class DepartmentController {
	 @Autowired
	    private DepartmentService service;
        
	    @GetMapping("/admin/departmentsview")
	    public String viewHomePage(Model model) {
	        List<Department> listdepartment = service.listAll();
	        model.addAttribute("listdepartment", listdepartment);	
	        return "admin/Dview";
	    }

	    @GetMapping("/admin/departments")
	    public String add(Model model) {
	        model.addAttribute("department", new Department());
	        return "admin/departments";
	    }

	    @RequestMapping(value = "/admin/departments/save", method = RequestMethod.POST)
	    public String saveDepartment(@ModelAttribute("department") Department saving) {
	        service.save(saving);
	        return "redirect:/admin/departmentsview";
	    }

	    @RequestMapping("/departmentedit/{id}")
	    public ModelAndView showEditDepartmentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("admin/departments");
	       Department saving = service.get(id);
	        mav.addObject("department", saving);
	        return mav;
	        
	    }
	    @RequestMapping("/departmentdelete/{id}")
	    public String deleteDepartment(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/admin/departmentsview";
	    }
}
