package com.microservices.user.user_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservices.user.user_service.entity.User;
import com.microservices.user.user_service.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> userList = (List<User>) userRepository.findAll();
        logger.info("User list from the DB - {} ", userList);
        return userList;
	}
	
	@Override
	public User getUser(Long id) {
		User user = userRepository.findById(id).get();
        logger.info("User from the DB - {} ", user);
        return user;		
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
        logger.info("User added - {}", user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
        logger.info("User with {} deleted from the DB", id);
	}

	@Override
	public List<User> getAllUserByFirstName(String firstName) {
		return userRepository.getAllUserByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastNameAndSort(String lName, String sortingParam) {
		return userRepository.getUsersByLastNameAndSort(lName, Sort.by(sortingParam));
	}

	@Override
	public void updatePhone(Long id, String phone) {
		userRepository.updatePhone(id, phone);
	}

	@Override
	public Page<User> getAllUsersByPages(int pageNumber, int numberOdElementsPerPage) {
		return userRepository.findAll(PageRequest.of(pageNumber, numberOdElementsPerPage));
	}
	
	public Slice<User> getAllUsersBySlices(int pageNumber, int numberOfElementsPerPage) {
        Slice<User> users = userRepository.findAll(PageRequest.of(pageNumber, numberOfElementsPerPage));
        return users;
    }
}
