package com.bot.chatbot.repository;

import org.springframework.data.repository.CrudRepository;

import com.bot.chatbot.model.Intent;


public interface IntentRepository extends CrudRepository<Intent, Integer> {

}
