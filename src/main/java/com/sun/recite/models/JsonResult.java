package com.sun.recite.models;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
    private String message;
    private T data = null;

    private Integer code;

    public JsonResult(String message, T data, Integer code) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public JsonResult(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public static JsonResult success(){
        return new JsonResult("操作成功",20000);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(msg,50000);
    }

    public static <T> JsonResult<T> success(T data) {
    	return new JsonResult("",data,20000);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
