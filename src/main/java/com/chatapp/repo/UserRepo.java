package com.chatapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
