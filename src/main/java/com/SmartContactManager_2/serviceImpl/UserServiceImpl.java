package com.SmartContactManager_2.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SmartContactManager_2.Repository.UserRepository;
import com.SmartContactManager_2.model.User;
import com.SmartContactManager_2.modelDto.UserDto;
import com.SmartContactManager_2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int registerUser(UserDto userDto) {
		int registerUser =0;
		try {
			User user = this.modelMapper.map(userDto, User.class);
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			registerUser = userRepository.registerUser(user);
			if (registerUser < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			return 0;
		}
		return registerUser;

	}
}
