package com.bt.course.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bt.course.security.entity.UserEntity;
import com.bt.course.security.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> {
    @Resource
    private UserMapper userMapper;

    /**
     * 获取所有用户,或根据条件查询
     */
    public List<UserEntity> getUserList(String searchKey) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(searchKey)){
            queryWrapper.like("username",searchKey);
        }
        //和实体类绑定，可以动态获取字段
        LambdaQueryWrapper<UserEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(UserEntity::getUser_name,searchKey);
        List<UserEntity> userEntities=userMapper.selectList(queryWrapper);
        return userEntities;
    }
}
