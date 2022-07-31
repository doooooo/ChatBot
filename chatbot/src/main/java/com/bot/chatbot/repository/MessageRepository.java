package com.bot.chatbot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bot.chatbot.model.Message;


public interface MessageRepository extends CrudRepository<Message, Integer> {
	
	List<Message> findByMessageContainsIgnoreCase(@Param("message") String message);


}
