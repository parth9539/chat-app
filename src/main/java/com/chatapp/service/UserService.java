package com.chatapp.service;

import com.chatapp.dto.UserDTO;
import com.chatapp.entity.User;

public interface UserService {

	public Boolean isUserNameExists(String userName);

	public String saveUser(UserDTO userDTO);

	public String updateUser(UserDTO userDTO);

	public User dtoToEntity(UserDTO userDto);

	public UserDTO entityToDto(User userEntity);

	public String deleteUser(UserDTO userDTO);

	public User findUserByUserName(String userName);

}
