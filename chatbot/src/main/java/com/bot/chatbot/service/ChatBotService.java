package com.bot.chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.chatbot.model.Intent;
import com.bot.chatbot.model.IntentMessage;
import com.bot.chatbot.model.Message;
import com.bot.chatbot.repository.*;

@Service
public class ChatBotService {
	
	//confidence threshold percentage
	private int threshold=80;

	@Autowired  
	IntentMessageRepository intentMessageRepository;  
	
	@Autowired  
	MessageRepository messageRepository;  
	
	@Autowired  
	IntentRepository intentRepository;  
	
	@Autowired  
	ReplyRepository replyRepository;  
	
	public String reply(String inputMessage) {
		
		String defaultMessage="Couldn't process input message";
		
		try {
		
		//retrieve training message containing inputMessage
		List<Message> messages=messageRepository.findByMessageContainsIgnoreCase(inputMessage);
		
		//Default message
		if(messages.size()==0) {
			return defaultMessage;
		}
		
		//for simplicity, we'll assume only first message result 
		Message message=messages.get(0);
		
		//retrieve intents with the above message id
		List<IntentMessage> intents=intentMessageRepository.findByMessageAndConfidenceGreaterThanEqual(message,threshold);
		
		//Default message
		if(intents.size()==0) {
			return defaultMessage;
		}
		
		//else, get the intent_id with max confidence
		int max=0;
		Intent intent=null;
		
		for(IntentMessage tempIntent:intents) {
			if(tempIntent.getConfidence()>max) {
				max=tempIntent.getConfidence();
				//get the Intent object by Id
				intent=tempIntent.getIntent();
			}
		}
		
		//get reply of retrieved intent
		if(intent!=null) {
			return intent.getReply().getReply_message();
		}
		else {
			return defaultMessage;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return defaultMessage;
		}
		
	}
	
}
