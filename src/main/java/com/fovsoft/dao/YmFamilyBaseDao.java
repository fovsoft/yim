package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:20
 * @description:
 **/
@Mapper
public interface YmFamilyBaseDao {

    @Insert(" insert into ym_family(szs,szx,szc,szz,szjd,lxdh,khyh,yhkh,pkhsx,sfdnytp,jhtpnd,fpnd,fpyy,sfjls,sfydfpbqh,bqfs,bqdz) values (#{szs},#{szx},#{szc},#{szz},#{szjd},#{lxdh},#{khyh},#{yhkh},#{pkhsx},#{sfdnytp},#{jhtpnd},#{fpnd},#{fpyy},#{sfjls},#{sfydfpbqh},#{bqfs},#{bqdz})")
    int addYmFamilyBase(YmFamilyBase ymFamilyBase);
}
