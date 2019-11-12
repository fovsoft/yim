package com.fovsoft.service;

import com.fovsoft.dao.YmFamilyBaseAdditionDao;
import com.fovsoft.dao.YmFamilyBaseConditionDao;
import com.fovsoft.dao.YmFamilyBaseDao;
import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAddition;
import com.fovsoft.entity.YmFamilyBaseCondition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public List<YmFamily> getList() {
        return null;
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
        }
        return id;
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
}
