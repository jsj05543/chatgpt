package com.chatgpt.domain.seivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chatgpt.domain.dto.ChatGptRequest;
import com.chatgpt.domain.dto.ChatGptResponse;
import com.chatgpt.domain.dto.Message;

@Service
public class ChatGptService {

	@Value("${openai.api.key}")
	private String apiKey;

	@Value("${openai.api.url}")
	private String apiUrl;

	@Autowired
	private RestTemplate restTemplate;

	public ChatGptResponse getChatCptResponse(String prompt) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + apiKey);

		ChatGptRequest chatGptRequest = new ChatGptRequest();
		chatGptRequest.setModel("gpt-3.5-turbo");
		chatGptRequest.setMessages(null);
		chatGptRequest.setMessages(List.of(new Message("system", prompt), new Message("user", prompt)));
		chatGptRequest.setMax_tokens(20);

		HttpEntity<ChatGptRequest> request = new HttpEntity<>(chatGptRequest, headers);

		return restTemplate.postForObject(apiUrl, request, ChatGptResponse.class);
	}

}
