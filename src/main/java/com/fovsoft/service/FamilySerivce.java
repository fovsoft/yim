package com.fovsoft.service;

import com.fovsoft.dao.YmFamilyBaseDao;
import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FamilySerivce {


    @Resource
    private YmFamilyBaseDao ymFamilyBaseDao;

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
            // 插入
            ymFamilyBaseDao.add(ymFamilyBase);
        }
        else {
            // 更新
        }
        return id;
    }
}
