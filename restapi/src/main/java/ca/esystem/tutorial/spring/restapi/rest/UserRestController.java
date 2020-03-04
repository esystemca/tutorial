package ca.esystem.tutorial.spring.restapi.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.esystem.tutorial.spring.restapi.dto.UserDto;
import ca.esystem.tutorial.spring.restapi.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.addUser(userDto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.updateUser(userDto));
	}
	
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Collection> getAllUsers() {
		return ResponseEntity.ok(userService.listUser());
	}
}

