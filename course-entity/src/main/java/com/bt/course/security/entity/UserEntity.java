package com.bt.course.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("course_user")
public class UserEntity extends Model<UserEntity> {
    /**
     * 用户id
     */
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    @TableField("nike_name")
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
     * 用户加密key
     */
    @TableField("user_activation_key")
    private String userActivationKey;
    /**
     * 状态
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 返回当前表的主键ID
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
