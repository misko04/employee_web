package com.pt.springsecurityjpa.service;

import com.pt.springsecurityjpa.model.Role;

import java.util.List;

public interface RolesService {
    List<Role> getAllRoles();

    void saveRole(Role role);

    Role getRoleById(long id);

    void deleteRoleById(long id);
}