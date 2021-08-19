package com.microservices.user.user_service.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import com.microservices.user.user_service.entity.User;

public interface UserService {

	public User getUser(Long userId);

	public void addUser(User user);

	public void deleteUser(Long userId);

	public List<User> getAllUsers();

	public List<User> getAllUserByFirstName(String name);
	
	void updatePhone(@Param("id") Long id, @Param("phone") String phone) ;

	List<User> getUsersByLastNameAndSort(@Param("lastName")String lName, String sortingParam);
	
	public Page<User> getAllUsersByPages(int pageNumber, int numberOdElementsPerPage);
	
	public Slice<User> getAllUsersBySlices(int pageNumber, int numberOfElementsPerPage);
}
