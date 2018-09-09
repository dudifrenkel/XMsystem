package com.XMsystem.Repository;

import com.XMsystem.Model.Administrator;
import org.springframework.data.repository.CrudRepository;


public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    Administrator findByUserName(String username);
}