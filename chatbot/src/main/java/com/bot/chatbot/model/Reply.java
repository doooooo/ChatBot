package com.bot.chatbot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="REPLY", schema = "public")
@Entity
public class Reply {
	
	@Id
	@Column(name="reply_id")
	int reply_id;
	
	@Column(name="reply_message")
	String reply_message;
	
	
	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_message() {
		return reply_message;
	}

	public void setReply_message(String reply_message) {
		this.reply_message = reply_message;
	}
	
	

}
