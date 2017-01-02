package com.aayud.restresource.messenger.service;

import java.util.Map;

import com.aayud.restresource.messenger.database.Database;
import com.aayud.restresource.messenger.model.Message;

public class MessageService {
	private Map<Long,Message> messages = Database.getMessages();
	
	public MessageService(){
		messages.put(1L,new Message(1,"Hello World","Kathiravan"));
		messages.put(2L,new Message(2,"Hello Jersey","Kathiravan"));
	}
	
	public Message getMessage(long id) 	{
		Message message= messages.get(id);
		if(message == null){
			return null;
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message, long id){
		message.setId(id);
		messages.replace(id, message);
		return message;
	}
	
	public void deleteMessage(long id){
		messages.remove(id);
	}
	
	public long getMessageCount(){
		return messages.size();
	}

}
