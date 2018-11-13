package com.primeton.chengjianyun.demo.service.impl;

import com.primeton.chengjianyun.demo.dao.UserDao;
import com.primeton.chengjianyun.demo.model.ServiceException;
import com.primeton.chengjianyun.demo.model.UserEntity;
import com.primeton.chengjianyun.demo.service.IUserService;
import com.primeton.chengjianyun.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengjianyun
 * @date 2018/10/19 16:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public Map login(UserEntity user) throws Exception{
        Map map = new HashMap();
        if(user!=null){
            if(user.getUserName()==null||user.getUserPassword()==null){
                throw new ServiceException(101,"用户名或密码不能为空",null);
            }else{
                if(userDao.login(user)!=null){
                    map.put("msg","登陆成功");
                    map.put("code",1);
                }else{
                    throw new ServiceException(102,"用户名或密码错误",null);
                }
            }
        }
        return map;
    }

    @Override
    public Map createUser(UserEntity user) throws Exception{
        Map map = new HashMap();
        if(user!=null){
            if(user.getUserPassword()==null||user.getUserName()==null){
                throw new ServiceException(101,"用户名或密码不能为空",null);
            }else if(user.getOrgId()==null){
                throw new ServiceException(105,"组织ID不能为空",null);
            }else{
                userDao.insert(user);
                map.put("msg","添加成功");
                map.put("code",1);
                map.put("user",user);
            }
        }
        return map;
    }

    @Override
    public Map removeUser(Integer userId) throws Exception{
        Map map = new HashMap();
        if(userId==null){
            throw new ServiceException(103,"id不能为空",null);
        }else{
            userDao.delete(userId);
            map.put("msg","删除成功");
            map.put("code",1);
        }
        return map;
    }

    @Override
    public Map modifyUser(UserEntity user) throws Exception{
        Map map = new HashMap();
        if(user!=null){
            if(user.getUserId()==null){
                throw new ServiceException(103,"id不能为空",null);
            }else{
                userDao.update(user);
                map.put("msg","修改成功");
                map.put("code",1);
                map.put("user",user);
            }
        }
        return map;
    }

    @Override
    @Transactional(readOnly = true)
    public Map queryUsers(Integer pageSize,Integer pageNumber,String userName,Integer orgId) throws Exception{
        Map map = new HashMap();
        Integer beginPage = 0;
        if (pageSize == null|| pageSize==0) {
            pageSize = 10;
        }
        if (pageNumber!= null && pageNumber!=0) {
            beginPage = (pageNumber - 1) * pageSize;
        }
        int totalPage = userDao.countUser(userName,orgId) / pageSize;
        if (userDao.countUser(userName,orgId) % pageSize != 0) {
            totalPage++;
        }
        map.put("list",userDao.query(pageSize,beginPage,userName,orgId));
        map.put("pageCount", userDao.countUser(userName,orgId));
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        map.put("totalPage", totalPage);
        return map;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUser(Integer userId) throws Exception {
        UserDTO dto = new UserDTO();
        if(userId!=null){
            dto = userDao.getUser(userId);
        }
        return dto;
    }
}
