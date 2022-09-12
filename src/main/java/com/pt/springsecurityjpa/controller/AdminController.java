package com.pt.springsecurityjpa.controller;

import com.pt.springsecurityjpa.repository.RoleRepository;
import com.pt.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

   /* @Test
    private void addAdminUser(){

        User user = new User();
        user.setUserName("Admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEmail("peter.tipul@gmail");

        Role role = new Role();
        role.setRole("Admin");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);
    }*/
}