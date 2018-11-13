package com.primeton.chengjianyun.demo.controller;

import com.primeton.chengjianyun.demo.model.OrgEntity;
import com.primeton.chengjianyun.demo.service.IOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author chengjianyun
 * @date 2018/10/22 16:37
 */
@Controller("orgController")
@RequestMapping(value = "/api/orgs")
@Api(tags={"组织管理接口","OrgController"})
public class OrgController {

    @Autowired
    private IOrgService iOrgService;

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ApiOperation(value = "新增组织结构")
    public Map createOrg(@ApiParam("组织管理实体类")@RequestBody OrgEntity org) throws Exception{
        return iOrgService.createOrg(org);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除组织结构")
    public Map removeOrg(@ApiParam("主键ID")@PathVariable("id") Integer id) throws Exception{
        return iOrgService.removeOrg(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{orgId}",method = RequestMethod.PUT)
    @ApiOperation(value = "修改组织结构")
    public Map modifyOrg(@ApiParam("组织管理实体类")@RequestBody OrgEntity org) throws Exception{
        return iOrgService.modifyOrg(org);
    }

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有组织")
    public List<OrgEntity> queryOrgs(@ApiParam("组织管理实体类")OrgEntity org) throws Exception{
        return iOrgService.queryOrgs(org);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询组织")
    public OrgEntity getOrg(@ApiParam("主键ID")@PathVariable("id") Integer id) throws Exception{
        return iOrgService.getOrg(id);
    }
}
