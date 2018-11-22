package com.primeton.chengjianyun.demo.model;


import java.io.Serializable;

/**
 * @author cjy
 * @date 2018/11/21 17:58
 */
public class ResultResponse implements Serializable {

    private String code;
    private String msg;
    private Object data;

    public ResultResponse() {

    }

    public ResultResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
