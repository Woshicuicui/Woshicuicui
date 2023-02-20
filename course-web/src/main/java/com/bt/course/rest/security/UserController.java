package com.bt.course.rest.security;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bt.course.base.dto.UserDto;
import com.bt.course.base.response.Response;
import com.bt.course.base.response.ResponseCode;
import com.bt.course.base.response.ResponseFactory;
import com.bt.course.security.entity.UserEntity;
import com.bt.course.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取所有用户,或根据条件查询
     * @param searchKey
     * @return
     */
    @GetMapping("users")
    public Response getUserList(@RequestParam (value = "searchKey",required = false)String searchKey){

        List<UserEntity> list = userService.getUserList(searchKey);
        return ResponseFactory.getSuccess(list );
    }

    /**
     * 获取所有用户,带分页
     * @param searchKey
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("usersPage")
    public Response getUserList(@RequestParam (value = "searchKey",required = false)String searchKey,
                                @RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize){
        IPage<UserEntity> list = userService.getUserList(searchKey,page,pageSize);
        return ResponseFactory.getSuccess(list );
    }

    /**
     * 获取单个用户
     * @param userId
     * @return
     */
    @GetMapping("users/{userId}")
    public Response  getSingleUser(@PathVariable long userId){
        UserEntity singleUser = userService.getById(userId);
        singleUser.setPassword(null);
        return  ResponseFactory.getSuccess(singleUser);
    }

    //添加一个用户

    //修改一个用户
    @PutMapping("users/{userId}")
    public Response updateUser(@PathVariable long userId, @RequestBody UserDto userDto){
        UserEntity user = UserEntity.builder()
                .id(userId)
                .nikName(userDto.getNikName())
                .userEmail(userDto.getUserEmail())
                .userStatus(userDto.getUserStatus())
                .build();
        return userService.updateById(user)?ResponseFactory.getSuccess(user):ResponseFactory.getError();
    }

    /**
     * 根据id删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("users/{userId}")
    public Response  deleteUser(long userId){
        Boolean result = userService.removeById(userId);
        return  result ? ResponseFactory.getSuccess():ResponseFactory.getError();
    }


}
