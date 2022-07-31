package com.bot.chatbot.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Ref: https://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example

@Table(name="INTENT_MESSAGE", schema = "public")
@Entity
public class IntentMessage {
	
	@Id
	@Column(name="intent_message_id")
	int intent_message_id;
	
	@Column(name="confidence")
	int confidence;
	
	@ManyToOne(targetEntity = Message.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
	Message message;
	
	@ManyToOne(targetEntity = Intent.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "intent_id")
	Intent intent;
	
	public int getIntent_message_id() {
		return intent_message_id;
	}

	public void setIntent_message_id(int intent_message_id) {
		this.intent_message_id = intent_message_id;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	

}
