package com.XMsystem.Repository;


import com.XMsystem.Model.TestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestResponseRepository extends CrudRepository<TestResponse, Long> {

}
