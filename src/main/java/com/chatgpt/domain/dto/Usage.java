package com.chatgpt.domain.dto;

import lombok.Data;

@Data
public class Usage {
	public int prompt_tokens;
	public int completion_tokens;
	public int total_tokens;

}
