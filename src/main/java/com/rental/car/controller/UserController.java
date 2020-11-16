package com.rental.car.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.car.dto.UserDTO;
import com.rental.car.exception.NotFoundException;
import com.rental.car.facade.UserFacade;
import com.rental.car.request.UserRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list-customers")	
	public List<UserDTO> getAllUsers() 
	{
		logger.info("****** Otteniamo la lista degli utenti *******");
		return userFacade.getAllUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list-customers/{id}") 
	public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) 
		throws NotFoundException
	{
		logger.info("****** Otteniamo l'utente con l'id " + id + " *******");
		
		UserDTO user = userFacade.getUserDtoById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('CUSTOMER') || hasRole('ADMIN')")
	@GetMapping("/{email}")
	public ResponseEntity<UserDTO> getUserProfile (@PathVariable(value="email") String email) {
		UserDTO user = userFacade.getUserDtoByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	 
	@PreAuthorize("permitAll")
	@PostMapping("/register")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserRequest userRequest) 
		throws Exception {
		logger.info("****** Viene aggiunto un nuovo utente " + userRequest.getName() + " ******");
		
		UserDTO user = userFacade.createUser(userRequest);
		return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('CUSTOMER') || hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
		logger.info("****** Viene modificato l'utente con id " + userDto.getId() + " ******");
		
		try {
			userFacade.updateUserDto(userDto.getId(), userDto);
			return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@DeleteMapping("/delete-customers/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		logger.info("****** Viene eliminato l'utente con id " + id + " ******");
		
		userFacade.deleteUserDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}