package com.fovsoft.service;

import com.fovsoft.dao.YmFamilyBaseAdditionDao;
import com.fovsoft.dao.YmFamilyBaseConditionDao;
import com.fovsoft.dao.YmFamilyBaseDao;
import com.fovsoft.dao.YmFamilyBaseMemberDao;
import com.fovsoft.entity.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class FamilySerivce {


    @Resource
    private YmFamilyBaseDao ymFamilyBaseDao;

    @Resource
    private YmFamilyBaseAdditionDao ymFamilyBaseAdditionDao;

    @Resource
    private YmFamilyBaseConditionDao ymFamilyBaseConditionDao;

    @Resource
    private YmFamilyBaseMemberDao ymFamilyBaseMemberDao;

    /**
     *
     * @return
     */
    public PageInfo getList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<YmFamilyBaseAndHouseHolder> list =  ymFamilyBaseDao.list();
        return new PageInfo(list);
    }

    /**
     *
     * @param id
     * @return
     */
    public int del(Integer id) {
        return ymFamilyBaseDao.delete(id);
    }

    public int delMember(Integer id) {
        return ymFamilyBaseMemberDao.delete(id);
    }

    public YmFamilyBaseMember getMember(Integer id) {
        return ymFamilyBaseMemberDao.get(id);
    }

    /**
     * 新增或更新家庭基本信息表
     *
     * @param ymFamilyBase
     * @return
     */
    public int addOrUpdateFamilyBase(YmFamilyBase ymFamilyBase) {
        int id = 0;
        if(ymFamilyBase.getId() == 0) {
            ymFamilyBase.setAddTime(new Timestamp(new Date().getTime()));
            // 插入
            ymFamilyBaseDao.add(ymFamilyBase);
            id = ymFamilyBase.getId();
        }
        else {
            // 更新
            ymFamilyBase.setUpdateTime(new Timestamp(new Date().getTime()));
            ymFamilyBaseDao.update(ymFamilyBase);
            id = ymFamilyBase.getId();
        }
        return id;
    }

    public YmFamilyBase get(int id) {
        return ymFamilyBaseDao.get(id);
    }

    /**
     *
     *
     * @param ymFamilyBaseAddition
     * @return
     */
    public int addOrUpdateFamilyBaseAddition(YmFamilyBaseAddition ymFamilyBaseAddition) {
        int id = 0;
        if(ymFamilyBaseAddition.getId() == 0) {
//            ymFamilyBaseAddition.setAddTime(new Timestamp(new Date().getTime()));
            // 插入
            ymFamilyBaseAdditionDao.add(ymFamilyBaseAddition);
            id = ymFamilyBaseAddition.getId();
        }
        else {
            // 更新
            ymFamilyBaseAdditionDao.update(ymFamilyBaseAddition);
            id = ymFamilyBaseAddition.getId();
        }
        return id;
    }



    public int addOrUpdateFamilyBaseCondition(YmFamilyBaseCondition ymFamilyBaseCondition) {
        int id = 0;
        if(ymFamilyBaseCondition.getId() == 0) {
            // 插入
            ymFamilyBaseConditionDao.add(ymFamilyBaseCondition);
            id = ymFamilyBaseCondition.getId();
        }
        else {
            // 更新
            ymFamilyBaseConditionDao.update(ymFamilyBaseCondition);
            id = ymFamilyBaseCondition.getId();
        }
        return id;
    }

    public int addOrUpdateFamilyBaseMember(YmFamilyBaseMember ymFamilyBaseMember) {
        int id = 0;
        if(ymFamilyBaseMember.getId() == 0) {
            // 插入
            ymFamilyBaseMemberDao.add(ymFamilyBaseMember);
            id = ymFamilyBaseMember.getId();
        }
        else {
            // 更新
            ymFamilyBaseMemberDao.update(ymFamilyBaseMember);
            id = ymFamilyBaseMember.getId();
        }
        return id;
    }

    public List<YmFamilyBaseMember> getMemberList(Integer fid) {
        List<YmFamilyBaseMember> list =  ymFamilyBaseMemberDao.list(fid);
        return list;
    }

    public int delAll(String inStr) {
        int affectRows = ymFamilyBaseDao.delAll(inStr);
        return affectRows;
     }

     public YmFamilyBaseAddition getAddiction(Integer fid) {
        return ymFamilyBaseAdditionDao.get(fid);
     }

    public YmFamilyBaseCondition getCondition(Integer fid) {
        return ymFamilyBaseConditionDao.get(fid);
    }
}
