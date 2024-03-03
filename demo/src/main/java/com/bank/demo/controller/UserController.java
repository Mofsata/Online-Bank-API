package com.bank.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.controller.dto.UserDTO;
import com.bank.demo.controller.mapper.UserMapper;
import com.bank.demo.entity.User;
import com.bank.demo.service.UserService;

import lombok.AllArgsConstructor;




@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private final UserService userServ;
	private final UserMapper mapper;
	
//	@GetMapping
//	public ResponseEntity<List<UserDTO>> getAllUsers(){
//		List<User> users = userServ.findAll();
//		List<UserDTO> userdto = new ArrayList<>();
//		users.forEach(u -> {
//			userdto.add(mapper.toDTO(u));
//		});
//		return new  ResponseEntity<>(userdto , HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<UserDTO> getOneUser(@PathVariable(value = "id" ) int id) {
//		UserDTO user = mapper.toDTO(userServ.findById(id));
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
	
	@GetMapping("/nid")
	public ResponseEntity<UserDTO> getByNID(@RequestParam(value = "nid" ) String nid) {
		UserDTO user = mapper.toDTO(userServ.findByNId(nid));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/phone")
	public ResponseEntity<UserDTO> getByPhone(@RequestParam(value = "phone") long phone) {
		UserDTO user = mapper.toDTO(userServ.findByPhone(phone));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody UserDTO userdto) {	
		User user = mapper.toUser(userdto);
		userServ.saveUser(user);
		return new ResponseEntity<>("User Saved Successfully", HttpStatus.CREATED);
	}
	
//	@PutMapping
//	public ResponseEntity<String> putUser(@RequestBody UserDTO userdto) {	
//		User user = mapper.toUser(userdto);
//		userServ.saveUser(user);
//		return new ResponseEntity<>("User Saved Successfully", HttpStatus.ACCEPTED);
//	}
	
	@PatchMapping("/nid")
	public ResponseEntity<UserDTO> patchUser(@RequestBody UserDTO userdto ,@RequestParam(value = "nid") String nid) {	
		User user = userServ.editUser(nid, mapper.toUser(userdto));
		UserDTO userOut = mapper.toDTO(user);
		return new ResponseEntity<>(userOut, HttpStatus.ACCEPTED);
	}
}
