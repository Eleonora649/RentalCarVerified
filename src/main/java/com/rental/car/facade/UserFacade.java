package com.rental.car.facade;

import java.text.ParseException;
import java.util.List;

import com.rental.car.dto.UserDTO;
import com.rental.car.request.UserRequest;

public interface UserFacade {
		
	List<UserDTO> getAllUsers();
	
	UserDTO getUserDtoById(Long id);
	
	UserDTO createUser(UserRequest userRequest) throws Exception;
	
	UserDTO updateUserDto(Long id, UserDTO userDto) throws ParseException;
	
	void deleteUserDto(Long id);

	UserDTO getUserDtoByEmail(String email);

}