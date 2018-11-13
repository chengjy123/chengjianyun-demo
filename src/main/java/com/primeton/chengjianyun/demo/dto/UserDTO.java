package com.primeton.chengjianyun.demo.dto;

import com.primeton.chengjianyun.demo.model.UserEntity;

import java.io.Serializable;

/**
 * @author chengjianyun
 * @date 2018/10/31 13:52
 */
public class UserDTO extends UserEntity implements Serializable {
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 组织简称
     */
    private String orgShortName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }
}
