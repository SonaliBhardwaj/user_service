package com.microservices.user.user_service.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.user.user_service.entity.Contact;
import com.microservices.user.user_service.entity.User;
import com.microservices.user.user_service.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable Long userId) {
		User user = userService.getUser(userId);

		if(user != null) {
			List<Contact> contactList = null;
			try {
				contactList = restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);
			}
			catch(Exception e) {
				System.out.println("Not able to communicate to Contact Service...");
			}
			user.setContacts(contactList != null ? contactList : new ArrayList<Contact>());
		}

		return user;
	}
	
	@GetMapping("/contact/user/{userId}")
	public List<Contact> getContactsForUser(@PathVariable Long userId) {
		try {
			List<Contact> contactList = restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);
			return contactList;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Not able to communicate to Contact Service...");
		}
		return null;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		userService.addUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/updatePhone/{id}/{phone}")
	public String updateUser(@PathVariable Long id, @PathVariable String phone) {
		userService.updatePhone(id, phone);
		return "Updated User Successfully!!";
	}

	@GetMapping("/getAllUserByName/{name}")
	public List<User> getAllUsersByFirstName(@PathVariable String name){
		return userService.getAllUserByFirstName(name);
	}

	//This end-point will get the Users with Last Name and sort the result
	@GetMapping("/getAllUserByLastName/{lastName}/{sortedParam}")
	public List<User> getUsersByLastNameAndSort(@PathVariable String lastName, @PathVariable String sortedParam){
		return userService.getUsersByLastNameAndSort(lastName, sortedParam);
	}

	@GetMapping("/getAllUsersByPages/{pageNumber}/{numberOdElementsPerPage}")
	public Page<User> getAllUsersByPages(@PathVariable String pageNumber, @PathVariable String numberOdElementsPerPage){
		return userService.getAllUsersByPages(Integer.parseInt(pageNumber), Integer.parseInt(numberOdElementsPerPage));
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "User with Id " + id + " deleted";
	}
}
