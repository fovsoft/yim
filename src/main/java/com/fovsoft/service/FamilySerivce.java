package com.fovsoft.service;

import com.fovsoft.dao.YmFamilyDao;
import com.fovsoft.entity.YmFamily;
import com.fovsoft.security.dao.SysMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FamilySerivce {


    @Resource
    private YmFamilyDao ymFamilyDao;

    public List<YmFamily> getList() {
        return null;
    }
}
