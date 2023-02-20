package com.bt.course.base.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.bt.course.security.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data //lom book注解
@TableName("course_user")
@Builder
public class UserDto extends Model<UserEntity> {

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nikName;
    /**
     * 邮箱
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 手机号
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 状态
     */
    @TableField("user_status")
    private Integer userStatus;
}
