package com.bt.course.base.response;

public class ResponseFactory {

    public ResponseFactory(){

    }
    public static <T>Response<T> getResponse(int code,String message,T data){
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


    public static <T>Response<T> getSuccess(T data){

     return getResponse(ResponseCode.success.getCode(),ResponseCode.success.getMessage(),data);
    }

    public static <T>Response<T> getError(){
        return getResponse(ResponseCode.error.getCode(),ResponseCode.error.getMessage(),null);
    }

    public static <T>Response<T> getError(ResponseCode responseCode){
        return getResponse(responseCode.getCode(),responseCode.getMessage(),null);
    }
}
