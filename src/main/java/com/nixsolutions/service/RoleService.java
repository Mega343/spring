package com.nixsolutions.service;


import com.nixsolutions.bean.Role;

import java.util.List;

public interface RoleService {

    public boolean add(Role role);

    public boolean edit(Role role);

    public boolean delete(Integer id);

    public Role getRole(Integer id);

    public Role getRoleByName(String name);

    public List<Role> getAllRoles();
}
