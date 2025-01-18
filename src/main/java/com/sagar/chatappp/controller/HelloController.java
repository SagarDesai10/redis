package com.sagar.chatappp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/chatapp")
public class HelloController {
	
	@GetMapping(value="/hello")
	public ResponseEntity hello()
	{
		return ResponseEntity.ok().body("HELLO");
	}

}
