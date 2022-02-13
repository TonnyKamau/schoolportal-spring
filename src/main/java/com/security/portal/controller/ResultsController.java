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

import com.security.portal.models.Results;
import com.security.portal.models.Unit;
import com.security.portal.models.User;
import com.security.portal.service.ResultsService;
import com.security.portal.service.UnitService;
import com.security.portal.service.UserService;



@Controller
public class ResultsController {
	@Autowired
    private UserService usersservice;
	 @Autowired
	    private UnitService unitservice;
	 @Autowired
	    private ResultsService service;

	    @GetMapping("/admin/resultsview")
	    public String viewResultsPage(Model model) {
	        List<Results> listresults = service.listAll();
	        model.addAttribute("listresults", listresults);	
	        return "admin/RSview";
	    }

	    @GetMapping("/admin/results")
	    public String addResults(Model model) {
	        model.addAttribute("results", new Results());
	        List<User> listuser = usersservice.listAll();
	        model.addAttribute("listuser", listuser);
	        List<Unit> listunit = unitservice.listAll();
	        model.addAttribute("listunit", listunit);	
	        return "admin/result";
	    }

	    @RequestMapping(value = "/admin/results/save", method = RequestMethod.POST)
	    public String saveResult(@ModelAttribute("result") Results result) {
	        service.save(result);
	        return "redirect:/admin/resultsview";
	    }
	    @RequestMapping(value = "/lecturer/results/save", method = RequestMethod.POST)
	    public String saveLecedit(@ModelAttribute("result") Results result) {
	        service.save(result);
	        return "redirect:/lecturer/results";
	    }
        @RequestMapping("/lecturereditresults/{id}")
	    public ModelAndView staffEditResultPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("lec/editresults");
	        Results results = service.get(id);
	        mav.addObject("results", results);
	        return mav;
	        }
	    @RequestMapping("/editResult/{id}")
	    public ModelAndView showEditResultPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("admin/editresult");
	        Results results = service.get(id);
	        mav.addObject("results", results);
	        return mav;
	        
	    }
	    @RequestMapping("/deleteResult/{id}")
	    public String deleteResult(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/admin/resultsview";
	    }
}
