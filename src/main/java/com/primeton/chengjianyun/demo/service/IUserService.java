package com.primeton.chengjianyun.demo.service;

import com.primeton.chengjianyun.demo.model.UserEntity;
import com.primeton.chengjianyun.demo.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * 用户管理服务接口
 * @author chengjianyun
 * @date 2018/10/19 16:27
 */
public interface IUserService {
    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    Map login(UserEntity user) throws Exception;

    /**
     * 新增用户
     * @param user 用户实体
     * @return
     * @throws Exception
     */
    Map createUser(UserEntity user) throws Exception;

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    Map removeUser(Integer userId) throws Exception;

    /**
     * 修改用户
     * @param user 用户实体
     * @return
     * @throws Exception
     */
    Map modifyUser(UserEntity user) throws Exception;

    /**
     * 查询全部用户
     * @param pageSize 页数
     * @param pageNumber 当前页
     * @param userName 用户名
     * @param orgId 组织ID
     * @return
     * @throws Exception
     */
    Map queryUsers(Integer pageSize,Integer pageNumber,String userName,Integer orgId) throws Exception;

    /**
     * 根据主键查询用户
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    UserDTO getUser(Integer userId) throws Exception;
}
