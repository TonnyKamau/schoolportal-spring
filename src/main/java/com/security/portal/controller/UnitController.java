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
import com.security.portal.models.Unit;
import com.security.portal.service.DepartmentService;
import com.security.portal.service.UnitService;





@Controller
public class UnitController {
	 @Autowired
	    private UnitService service;
	 @Autowired
	    private DepartmentService departmentservice;

	    @GetMapping("/admin/unitsview")
	    public String viewUnitPage(Model model) {
	        List<Unit> listunit = service.listAll();
	        model.addAttribute("listunit", listunit);	
	        return "admin/UNview";
	    }

	    @GetMapping("/admin/units")
	    public String addUnit(Model model) {
	        model.addAttribute("unit", new Unit());
	        List<Department> listdepartment = departmentservice.listAll();
	        model.addAttribute("listdepartment", listdepartment);
	        return "admin/courseunit";
	    }

	    @RequestMapping(value = "/admin/courseunits/save", method = RequestMethod.POST)
	    public String saveUnit(@ModelAttribute("unit") Unit unit) {
	        service.save(unit);
	        return "redirect:/admin/unitsview";
	    }

	    @RequestMapping("/editUnit/{id}")
	    public ModelAndView showEditUnitPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("admin/editcourseunit");
	        Unit unit = service.get(id);
	        mav.addObject("unit", unit);
	        return mav;
	        
	    }
	    @RequestMapping("/deleteUnit/{id}")
	    public String deleteUnit(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/admin/unitsview";
	    }
}
