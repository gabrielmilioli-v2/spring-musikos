package com.milioli.musikos.resource;

import com.milioli.musikos.record.Login;
import com.milioli.musikos.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping("/check-password")
    public void checkPassword(@RequestBody Login login) {
        loginService.checkPassword(login);
    }

}
