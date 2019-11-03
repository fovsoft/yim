package com.fovsoft.service;

import com.fovsoft.dao.YmFamilyDao;
import com.fovsoft.dao.YmRegionDao;
import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmRegion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionSerivce {


    @Resource
    private YmRegionDao ymRegionDao;

    public List<YmRegion> getList(Integer id) {
        return ymRegionDao.getRegionList(id);
    }
}
