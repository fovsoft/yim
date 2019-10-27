package com.fovsoft.security.dao;

import com.fovsoft.security.bean.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/15 17:24
 * @description: 用户角色信息
 **/

@Mapper
public interface SysRoleDao {



    @Select("select distinct fr.* from frm_role fr " +
            "inner join frm_sysuser_role fsr  on fr.roleId = frs.roleId " +
            "where fsr.userId = #{userId}")
    @Results(id="sysRoleResultMap",value = {
            @Result(property = "roleId",column = "roleId"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "description",column = "description"),
            @Result(property = "zt",column = "zt"),
            @Result(property = "cjsj",column = "cjsj"),
            @Result(property = "gxsj",column = "gxsj")
    })
    List<SysRole> findRoleByUserId(int userId);
}
