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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp()
    {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testUser() throws Exception {
        /**
         * 登录
         */
        UserEntity user1 = new UserEntity();
        user1.setUserName("admin");
        user1.setUserPassword("123");
        iUserService.login(user1);
        Assert.assertNotNull("登录失败", iUserService.login(user1));
        // 构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/users/actions/login").param("userName", "admin").param(
                "userPassword", "123");

        // 发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // 请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        /**
         * 新增
         */
        UserEntity user = new UserEntity();
        user.setUserName("新增测试");
        user.setUserPassword("新增");
        user.setOrgId(1);
        userController.createUser(user);
        Assert.assertNotNull("新增用户失败", userController.createUser(user));
        Assert.assertEquals("新增异常",user);

        /**
         * 修改
         */
        user.setUserName("修改测试");
        user.setUserPassword("修改");
        user.setOrgId(1);
        userController.modifyUser(user);
        Assert.assertNotNull("修改用户失败",  userController.modifyUser(user));
        Assert.assertEquals("修改异常",user.getUserId());
        /**
         * 查询
         */
        userController.getUser(user.getUserId());
        /**
         * 删除
         */
        userController.removeUser(user.getUserId());
        Assert.assertNotNull("删除用户失败", userController.removeUser(user.getUserId()));
        Assert.assertEquals("删除异常",user.getUserId());
    }
}
