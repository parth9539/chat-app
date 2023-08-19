package com.chatapp.service.impl;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.dto.UserDTO;
import com.chatapp.entity.User;
import com.chatapp.repo.UserRepo;
import com.chatapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	UserRepo userRepo;

	@Override
	public User findUserByUserName(String userName) {
		if (isUserNameExists(userName)) {
			return userRepo.findByUserName(userName).get();
		}
		return null;
	}

	@Override
	public String saveUser(UserDTO userDTO) {
		if (isUserNameExists(userDTO.getUserName())) {
			return "Username already exists";
		}
		User user = dtoToEntity(userDTO);
		user.setIsActive(true);
		user.setCreatedOn(LocalDateTime.now());
		userRepo.save(user);
		return "User saved";
	}

	@Override
	public String updateUser(UserDTO userDTO) {
		if (!isUserNameExists(userDTO.getUserName())) {
			return "Username doesnot exist";
		}
		User user = dtoToEntity(userDTO);
		user.setIsActive(true);
		user.setModifiedOn(LocalDateTime.now());
		userRepo.save(user);
		return "User updated";
	}

	@Override
	public String deleteUser(UserDTO userDTO) {
		User user = dtoToEntity(userDTO);
		user.setIsActive(false);
		userRepo.save(user);
		return "User deleted";
	}

	@Override
	public Boolean isUserNameExists(String userName) {
		return userRepo.findByUserName(userName).isPresent();
	}

	@Override
	public User dtoToEntity(UserDTO userDto) {
		User userEntity = modelMapper.map(userDto, User.class);
		return userEntity;
	}

	@Override
	public UserDTO entityToDto(User userEntity) {
		UserDTO userDto = modelMapper.map(userEntity, UserDTO.class);
		return userDto;
	}

}
