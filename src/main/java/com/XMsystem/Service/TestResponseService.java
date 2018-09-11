package com.XMsystem.Service;


import com.XMsystem.Model.TestResponse;
import com.XMsystem.Repository.TestResponseRepository;
import org.springframework.stereotype.Service;



@Service
public class TestResponseService {

    private final TestResponseRepository testResponseRepository;

    public TestResponseService(TestResponseRepository testResponseRepository) {
        this.testResponseRepository = testResponseRepository;
    }

    public void addTestResponse(TestResponse testResponse) {
        testResponseRepository.save(testResponse);
    }

}
