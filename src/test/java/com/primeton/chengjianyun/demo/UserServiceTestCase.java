package com.primeton.chengjianyun.demo;

import com.primeton.chengjianyun.demo.controller.UserController;
import com.primeton.chengjianyun.demo.model.UserEntity;
import com.primeton.chengjianyun.demo.service.IUserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author chengjianyun
 * @date 2018/10/22 14:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class UserServiceTestCase {

    @Autowired
    private UserController userController;
    @Autowired
    private IUserService iUserService;

    @Test
    public void testUser() throws Exception {
        /**
         * 登录
         */
        UserEntity user1 = new UserEntity();
        user1.setUserName("user");
        user1.setUserPassword("123");
        iUserService.login(user1);
        Assert.assertNotNull("登录失败", iUserService.login(user1));
        /**
         * 新增
         */
        UserEntity user = new UserEntity();
        user.setUserName("新增测试");
        user.setUserPassword("新增");
        user.setOrgId(1);
        userController.createUser(user);
        Assert.assertNotNull("新增用户失败", userController.createUser(user));

        /**
         * 修改
         */
        user.setUserName("修改测试");
        user.setUserPassword("修改");
        user.setOrgId(1);
        userController.modifyUser(user);
        Assert.assertNotNull("修改用户失败",  userController.modifyUser(user));
        /**
         * 查询
         */
        userController.getUser(user.getUserId());
        /**
         * 删除
         */
        userController.removeUser(user.getUserId());
        Assert.assertNotNull("删除用户失败", userController.removeUser(user.getUserId()));
    }
}
