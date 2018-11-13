package com.primeton.chengjianyun.demo.service;

import com.primeton.chengjianyun.demo.model.OrgEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织机构服务接口
 * @author chengjianyun
 * @date 2018/10/22 16:11
 */
public interface IOrgService {


    /**
     * 新增组织机构
     * @param org 组织实体
     * @return
     * @throws Exception
     */
    Map createOrg(OrgEntity org) throws Exception;

    /**
     * 删除组织机构
     * @param orgId 组织机构ID
     * @return
     * @throws Exception
     */
    Map removeOrg(Integer orgId) throws Exception;

    /**
     * 修改组织机构
     * @param org 组织机构实体
     * @return
     * @throws Exception
     */
    Map modifyOrg(OrgEntity org) throws Exception;

    /**
     * 查询组织机构
     * @param org 组织机构实体
     * @return
     * @throws Exception
     */
    List<OrgEntity> queryOrgs(OrgEntity org) throws Exception;

    /**
     * 根据主键查询组织机构
     * @param orgId 组织机构id
     * @return
     * @throws Exception
     */
    OrgEntity getOrg(Integer orgId) throws Exception;

    /**
     * 统计组织机构下用户数量
     * @param orgId 组织机构ID
     * @return
     * @throws Exception
     */
    int countUser(Integer orgId) throws Exception;
}
