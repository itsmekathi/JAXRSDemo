package com.aayud.restresource.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.aayud.restresource.messenger.model.Message;

public class Database {
	
	private static Map<Long, Message> messages= new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
