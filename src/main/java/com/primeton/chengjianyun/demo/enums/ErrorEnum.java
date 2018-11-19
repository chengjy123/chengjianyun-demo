package com.primeton.chengjianyun.demo.enums;

/**
 * @author cjy
 * @date 2018/11/19 10:31
 */
public enum ErrorEnum {
    SYSTEM_ERROR("00000","系统错误"),
    nameNotNull("00101","用户名密码不能为空"),
    password_error("00102","用户名或密码错误"),
    orgIdNotNull("00103","组织ID不能为空"),
    userIdNotNull("00104","用户ID不能为空"),
    ;

    private String code;

    private String msg;

    ErrorEnum(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public String getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }
}
