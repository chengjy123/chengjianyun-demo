package com.primeton.chengjianyun.demo.dao;

import com.primeton.chengjianyun.demo.model.UserEntity;
import com.primeton.chengjianyun.demo.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    UserEntity login(UserEntity user);

    int insert(UserEntity user);

    int delete(int id);

    int update(UserEntity user);

    List<UserDTO> query(@Param("pageSize") Integer pageSize,@Param("beginPage") Integer beginPage,@Param("userName") String userName,@Param("orgId")Integer orgId);

    UserDTO getUser(Integer id);

    int countUser(@Param("userName") String userName,@Param("orgId") Integer orgId);
}
