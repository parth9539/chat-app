package com.chatapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chatapp.utils.Auditable;

@Entity
@Table
public class ChatRoom extends Auditable<ChatRoom> {

	@Id
	@Column(name = "chatroom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "name")
	String chatRoomName;
}
