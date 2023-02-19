package com.bt.course.base.response;

public enum  ResponseCode {
    /**
     * 返回code码
     */
    success(200,"操作成功"),
    error(400,"发生错误"),
    please_login(401,"没有权限"),
    closure(300,"用户被禁用"),
    failure(500,"操作失败");


    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}