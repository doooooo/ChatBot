package com.bot.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.chatbot.service.ChatBotService;

@RestController
public class ChatbotController {
	
	@Autowired  
	ChatBotService chatService;  
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	@ResponseBody
	public String getReply(@RequestParam("input") String inputMessage) {
	    return chatService.reply(inputMessage);
	}
}
