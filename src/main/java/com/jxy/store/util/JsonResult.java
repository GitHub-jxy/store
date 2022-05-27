package com.jxy.store.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {

    //状态码
    private Integer code;
    //描述信息
    private String message;
    //数据类型
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer code) {
        this.code = code;
    }

    public JsonResult(Integer code, E data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(Integer code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
