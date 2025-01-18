package com.sagar.chatappp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/app/v1/chatapp")
public class HelloController {
	
	@GetMapping(value="/hello")
	public ModelAndView hello(ModelMap model)
	{
		model.addAttribute("userMessages","user");
		model.addAttribute("friendMessages", "friend");
		model.addAttribute("message","some message");
		return new ModelAndView("chat",model);
	}

}
