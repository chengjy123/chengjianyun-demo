package com.primeton.chengjianyun.demo.controller;

import com.primeton.chengjianyun.demo.model.UserEntity;
import com.primeton.chengjianyun.demo.service.IUserService;
import com.primeton.chengjianyun.demo.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author chengjianyun
 * @date 2018/10/19 16:17
 */
@Controller("userController")
@RequestMapping("/api/users")
@Api(tags={"用户管理接口","UserController"})
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping(value = "/actions/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public Map login(@ApiParam("用户实体类") @RequestBody UserEntity users, HttpSession session) throws Exception {
        session.setAttribute("name",users.getUserName());
        return iUserService.login(users);
    }

    @ResponseBody
    @RequestMapping(value = "/actions/login",method = RequestMethod.DELETE)
    @ApiOperation(value = "用户登出")
    public void logout(HttpSession session){
        session.removeAttribute("name");
    }

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ApiOperation(value = "用户新增")
    public Map createUser(@ApiParam("用户实体类")@RequestBody UserEntity user) throws Exception {
        return iUserService.createUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    public Map removeUser(@ApiParam("主键ID")@PathVariable("id") Integer id) throws Exception{
        return iUserService.removeUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户")
    public Map modifyUser(@ApiParam("用户实体类")@RequestBody UserEntity user) throws Exception{
        return iUserService.modifyUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(value = "用户查询全部")
    public Map queryUsers(@ApiParam("每页条数")Integer pageSize,@ApiParam("当前页")Integer pageNumber,@ApiParam("用户名")String userName,@ApiParam("组织ID")Integer orgId) throws Exception{
        return iUserService.queryUsers(pageSize,pageNumber,userName,orgId);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "用户根据ID查询")
    public UserDTO getUser(@ApiParam("用户ID")@PathVariable("id") Integer id) throws Exception{
        UserDTO record = iUserService.getUser(id);
        return record;
    }
}
