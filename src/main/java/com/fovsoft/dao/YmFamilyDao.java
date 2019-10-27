package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:20
 * @description:
 **/
@Mapper
public interface YmFamilyDao {

//    List<>

    /**
     * 功能描述: 往贫困人员家庭表中写入信息
     * @author by tpc
     * @date 2019/10/18 9:42
     * @param ymFamily
     * @return int
     */
    @Insert(" insert into ym_family(szs,szx,szc,szz,szjd,lxdh,khyh,yhkh,pkhsx,sfdnytp,jhtpnd,fpnd,fpyy,sfjls,sfydfpbqh,bqfs,bqdz) values (#{szs},#{szx},#{szc},#{szz},#{szjd},#{lxdh},#{khyh},#{yhkh},#{pkhsx},#{sfdnytp},#{jhtpnd},#{fpnd},#{fpyy},#{sfjls},#{sfydfpbqh},#{bqfs},#{bqdz})")
    int addYmFamily(YmFamily ymFamily);
}
