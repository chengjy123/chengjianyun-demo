package com.primeton.chengjianyun.demo;

import com.primeton.chengjianyun.demo.controller.OrgController;
import com.primeton.chengjianyun.demo.model.OrgEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengjianyun
 * @date 2018/10/31 14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class OrgServiceTestCase {

    @Autowired
    private OrgController orgController;

    @Test
    public void testOrg() throws Exception{
        /**
         * 新增
        */
        OrgEntity org = new OrgEntity();
        org.setOrgName("新增测试");
        org.setOrgShortName("新增");
        orgController.createOrg(org);
        Assert.assertNotNull("创建数据记录失败", orgController.createOrg(org));
        /**
         * 修改
         */
        org.setOrgName("修改测试");
        org.setOrgShortName("修改");
        orgController.modifyOrg(org);
        Assert.assertNotNull("修改数据记录失败", orgController.modifyOrg(org));
        /**
         * 查询
         */
        orgController.getOrg(org.getOrgId());
        Assert.assertNotNull("查询数据记录失败", orgController.getOrg(org.getOrgId()));
        /**
         * 删除
         */
        orgController.removeOrg(org.getOrgId());
        Assert.assertNotNull("删除数据记录失败", orgController.removeOrg(org.getOrgId()));
    }
}
