package com.chatapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
