package com.sun.recite.models;

import java.io.Serializable;

public class JsonResult implements Serializable{
    private String message;
    private Object data = null;

    private Integer code;

    public JsonResult(String message, Object data, Integer code) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public JsonResult(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public static JsonResult success(){
        return new JsonResult("操作成功",200);
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

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
