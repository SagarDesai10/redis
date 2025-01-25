package com.sagar.chatappp.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.chatappp.dto.MessageDTO;
import com.sagar.chatappp.dto.MsgResponseDTO;

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
	
	@GetMapping(value="/send-msg")
	public ResponseEntity<MsgResponseDTO> sendMsg(@RequestParam("message") String message)
	{
		MessageDTO msg1=new MessageDTO("you",message,"user");
		MessageDTO msg2=new MessageDTO("romil","hi sagar","friend");
		
		MsgResponseDTO msg=new MsgResponseDTO(Arrays.asList(msg1,msg2));
		
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(msg);
	}

}
