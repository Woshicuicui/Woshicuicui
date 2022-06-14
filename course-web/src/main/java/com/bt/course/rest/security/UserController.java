package com.bt.course.rest.security;

import com.bt.course.security.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @RequestMapping("demo1")
    public String demo1(){
        UserEntity t = new UserEntity();
        t.setId(3L);
        t.setUsername("hangman");
        t.setPassword("123456");
        t.insert();
        return "success";
    }

}
