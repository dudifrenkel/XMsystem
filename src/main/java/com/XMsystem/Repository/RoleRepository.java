package com.XMsystem.Repository;

import com.XMsystem.Model.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}