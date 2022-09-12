package com.pt.springsecurityjpa.service;

import com.pt.springsecurityjpa.model.User;
import com.pt.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUserById(long id) {

        return userRepository.getReferenceById(id);
    }
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
