package com.chatgpt.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatGptResponse {
	public String id;
	public String object;
	public int created;
	public List<Choice> choices;
	public Usage usage;

}
