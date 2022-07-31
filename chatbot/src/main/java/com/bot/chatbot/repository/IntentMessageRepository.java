package com.bot.chatbot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bot.chatbot.model.IntentMessage;
import com.bot.chatbot.model.Message;


public interface IntentMessageRepository extends CrudRepository<IntentMessage, Integer> {
	
	List<IntentMessage> findByMessageAndConfidenceGreaterThanEqual(@Param("message") Message message,
			@Param("confidence") int confidence);

}
