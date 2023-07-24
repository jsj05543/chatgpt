package com.chatgpt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chatgpt.app.form.ChatGptWebForm;
import com.chatgpt.domain.dto.ChatGptResponse;
import com.chatgpt.domain.seivice.ChatGptService;

@Controller
public class ChatGptWebController {

	@GetMapping("/")
	String index(Model model) {
		model.addAttribute("chatGptWebForm", new ChatGptWebForm("", ""));
		return "index";
	}

	@Autowired
	private ChatGptService chatGptService;

	@PostMapping(value = "/chatweb", params = "submit")
	public String searchAccount(Model model, @RequestParam("userInput") String userInput) {
		ChatGptResponse chatCPTResponse = chatGptService.getChatCptResponse(userInput);
		ChatGptWebForm chatGptWebForm = new ChatGptWebForm();
		chatGptWebForm.setUserInput(userInput);
		chatGptWebForm.setMessage(chatCPTResponse.getChoices().get(0).getMessage().getContent());
		model.addAttribute("chatGptWebForm", chatGptWebForm);
		return "index";
	}

}
