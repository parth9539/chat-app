package com.chatapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.entity.ChatRoom;

@Repository
public interface ChatRoomRepo extends JpaRepository<ChatRoom, Integer> {

}
