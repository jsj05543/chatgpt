package com.chatgpt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.domain.dto.ChatGptResponse;
import com.chatgpt.domain.seivice.ChatGptService;

@RestController
public class ChatGptApiController {

	@Autowired
	private ChatGptService chatGptService;

	@PostMapping("/chatapi")
	public ResponseEntity<ChatGptResponse> processInputRequest(@RequestBody String userInput) {
		ChatGptResponse chatCPTResponse = chatGptService.getChatCptResponse(userInput);
		return new ResponseEntity<>(chatCPTResponse, HttpStatus.OK);
	}

}
