package com.bot.chatbot.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="INTENT", schema = "public")
@Entity
public class Intent {
	
	@Id
	@Column(name="intent_id")
	int intent_id;
	
	@OneToOne(targetEntity = Reply.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id", referencedColumnName = "reply_id")
    Reply reply;
	
	@OneToMany(mappedBy = "intent")
	Set<IntentMessage> intentMessages;
	
	public int getIntent_id() {
		return intent_id;
	}

	public void setIntent_id(int intent_id) {
		this.intent_id = intent_id;
	}
	
	public Set<IntentMessage> getIntentMessages() {
	    return intentMessages;
	}
	

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

}
