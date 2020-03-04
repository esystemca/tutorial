package ca.esystem.tutorial.spring.restapi.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ca.esystem.tutorial.spring.restapi.dto.UserDto;
import ca.esystem.tutorial.spring.restapi.exception.ConflictException;
import ca.esystem.tutorial.spring.restapi.exception.NotFoundException;

@Service
public class UserService {

	public static HashMap<String,UserDto> userMap=new HashMap<String,UserDto>();
	
	public UserDto addUser(UserDto userDto) {
		userMap.forEach((key,value)->{
			if(value.getEmail().equalsIgnoreCase(userDto.getEmail())) {
				throw new ConflictException(userDto.getEmail()+" is existed already.");
			}
		});
		
		userDto.setUserId(UUID.randomUUID().toString());
		userMap.put(userDto.getUserId(), userDto);
		return userDto;
	}
	
	public UserDto updateUser(UserDto userDto) {
		if(!userMap.containsKey(userDto.getUserId())) {
			throw new NotFoundException("Not found "+userDto.getUserId());
		}
		userMap.put(userDto.getUserId(), userDto);
		return userDto;
	}
	
	public void deleteUser(String userId) {
		if(!userMap.containsKey(userId)) {
			throw new NotFoundException("Not found "+userId);
		}
		userMap.remove(userId);
	}
	
	public UserDto getUser(String userId) {
		if(!userMap.containsKey(userId)) {
			throw new NotFoundException("Not found "+userId);
		}
		return userMap.get(userId);
	}
	
	public Collection<UserDto> listUser(){
		return userMap.values();
	}
}

