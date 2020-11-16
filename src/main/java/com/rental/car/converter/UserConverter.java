package com.rental.car.converter;

import java.text.ParseException;
import java.util.List;

import com.rental.car.dto.UserDTO;
import com.rental.car.model.User;
import com.rental.car.request.UserRequest;

public interface UserConverter {

	User convert(UserDTO userDto) throws ParseException;
	
	List<User> convertAll(List<UserDTO> userDto) throws Exception;
	
	UserDTO reverseConvert(User user);
	
	List<UserDTO> reverseConvertAll(List<User> user);

	User convert(UserRequest userRequest);
}