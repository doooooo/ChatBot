package com.bot.chatbot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="MESSAGE", schema = "public")
@Entity
public class Message {
	
	@Id
	@Column(name="message_id")
	int message_id;
	
	@Column(name="message")
	String message;
	
	@OneToMany(mappedBy = "message")
	Set<IntentMessage> intentMessages;
	
	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<IntentMessage> getIntentMessages() {
		return intentMessages;
	}

	public void setIntentMessages(Set<IntentMessage> intentMessages) {
		this.intentMessages = intentMessages;
	}
	

}
