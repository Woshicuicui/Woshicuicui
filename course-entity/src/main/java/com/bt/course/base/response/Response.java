package com.bt.course.base.response;
import lombok.Data;

@Data
public class Response<T> {
   private int code;
   private String message;
   private T data;

}