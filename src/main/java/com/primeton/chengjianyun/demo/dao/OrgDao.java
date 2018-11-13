package com.primeton.chengjianyun.demo.dao;


import com.primeton.chengjianyun.demo.model.OrgEntity;

import java.util.List;

/**
 * @author chengjianyun
 * @date 2018/10/22 15:51
 */
public interface OrgDao {

    int insert(OrgEntity org);

    int delete(int id);

    int update(OrgEntity org);

    List<OrgEntity> query(OrgEntity org);

    OrgEntity getOrg(Integer id);

    int countUser(Integer id);

}
