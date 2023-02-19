package com.bt.course.rest.security;

import com.bt.course.base.response.Response;
import com.bt.course.base.response.ResponseCode;
import com.bt.course.base.response.ResponseFactory;
import com.bt.course.security.entity.UserEntity;
import com.bt.course.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取所有用户,或根据条件查询
     */
    @GetMapping("users")
    public Response getUserList(@RequestParam (value = "searchKey",required = false)String searchKey){

        List<UserEntity> list = userService.getUserList(searchKey);
        return ResponseFactory.getSuccess(list );
    }

    //获取单个用户
    //添加一个用户
    //修改一个用户
    //删除用户


}
