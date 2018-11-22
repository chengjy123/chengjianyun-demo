package com.primeton.chengjianyun.demo.enums;

/**
 * @author cjy
 * @date 2018/11/19 10:31
 */
public enum ErrorEnum {
    NAME_NOT_NULL("100101","用户名密码不能为空"),
    PASSWORD_ERROR("100102","用户名或密码错误"),
    ORGID_NOT_NULL("100103","组织ID不能为空"),
    USERID_NOT_NULL("100104","用户ID不能为空"),
    ORG_NOT_NULL("100201","组织名称或简称不能为空"),
    EXIST_USER("100202","此组织下有用户,不允许删除"),
    EXIST_ORG("100203","此组织下有子组织,不允许删除")
    ;

    private String code;

    private String msg;

    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
