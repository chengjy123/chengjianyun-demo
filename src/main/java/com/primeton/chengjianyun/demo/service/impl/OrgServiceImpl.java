package com.primeton.chengjianyun.demo.service.impl;

import com.primeton.chengjianyun.demo.enums.ErrorEnum;
import com.primeton.chengjianyun.demo.exception.ServiceException;
import com.primeton.chengjianyun.demo.model.OrgEntity;
import com.primeton.chengjianyun.demo.service.IOrgService;
import com.primeton.chengjianyun.demo.dao.OrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengjianyun
 * @date 2018/10/22 16:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl implements IOrgService {

    @Autowired
    private OrgDao orgDao;

    @Override
    public Map createOrg(OrgEntity org) throws Exception {
        Map map = new HashMap();
        if(org!=null){
            if(org.getOrgName()==null||org.getOrgShortName()==null){
                throw new ServiceException(ErrorEnum.ORG_NOT_NULL);
            }else if(org.getParentId()==null){
                org.setParentId(0);
            }else{
                orgDao.insert(org);
                map.put("msg","添加成功");
                map.put("code",1);
                map.put("org",org);
            }
        }
        return map;
    }

    @Override
    public Map removeOrg(Integer orgId) throws Exception {
        Map map = new HashMap();
        OrgEntity org = new OrgEntity();
        org.setOrgId(orgId);
        List<OrgEntity> list = orgDao.query(org);
        if(orgId==null){
            throw new ServiceException(ErrorEnum.ORGID_NOT_NULL);
        }else if(orgDao.countUser(orgId)>0){
            throw new ServiceException(ErrorEnum.EXIST_USER);
        }else if(list.size()>0){
            throw new ServiceException(ErrorEnum.EXIST_ORG);
        }else{
            orgDao.delete(orgId);
            map.put("msg","删除成功");
            map.put("code",1);
        }
        return map;
    }

    @Override
    public Map modifyOrg(OrgEntity org) throws Exception {
        Map map = new HashMap();
        if(org!=null){
            if(org.getOrgId()==null){
                throw new ServiceException(ErrorEnum.ORGID_NOT_NULL);
            }else{
                orgDao.update(org);
                map.put("msg","修改成功");
                map.put("code",1);
                map.put("org",org);
            }
        }
        return map;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrgEntity> queryOrgs(OrgEntity org)  throws Exception{
        List<OrgEntity> list = new ArrayList<OrgEntity>();
        if(org!=null){
            list = orgDao.query(org);
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public OrgEntity getOrg(Integer orgId) throws Exception {
        OrgEntity org = new OrgEntity();
        if(org!=null){
            org = orgDao.getOrg(orgId);
        }
        return org;
    }

    @Override
    @Transactional(readOnly = true)
    public int countUser(Integer orgId) throws Exception {
        int count = 0;
        if(orgId!=null){
            count = orgDao.countUser(orgId);
        }
        return count;
    }
}
