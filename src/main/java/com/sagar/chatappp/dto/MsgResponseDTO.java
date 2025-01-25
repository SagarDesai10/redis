package com.sagar.chatappp.dto;

import java.util.List;

public class MsgResponseDTO {
	
	private List<MessageDTO> messages;
	
	public MsgResponseDTO(List<MessageDTO> message)
	{
		this.messages=message;
		
	}

	public List<MessageDTO> getMessage() {
		return messages;
	}

	public void setMessage(List<MessageDTO> message) {
		this.messages = message;
	}
	
	

}
