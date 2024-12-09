package com.magda.demo.service;

import com.magda.demo.model.User;
import com.magda.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}