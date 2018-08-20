package com.XMsystem.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateTester(String user, String pw){

        return user.equalsIgnoreCase("tester")
                && pw.equalsIgnoreCase("pw");
    }
}
