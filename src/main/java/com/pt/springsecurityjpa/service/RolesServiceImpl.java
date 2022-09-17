package com.pt.springsecurityjpa.service;

import com.pt.springsecurityjpa.model.Role;
import com.pt.springsecurityjpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
}