package com.XMsystem.Repository;

import com.XMsystem.Model.Administrator;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    @Query("FROM Administrator WHERE userName=:username ")
    Administrator findByUsername(@Param("username") String username);

//    Administrator findByUsername(String username);
}