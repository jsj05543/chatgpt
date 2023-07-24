package com.chatgpt.domain.dto;

import lombok.Data;

@Data
public class Choice {
	public int index;
	public Message message;
	public String finish_reason;

}
