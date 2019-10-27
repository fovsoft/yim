package com.fovsoft.security.dao;

import com.fovsoft.security.bean.SysMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11 15:00
 * @description:
 **/

@Mapper
public interface SysMenuDao {


    @Select("select distinct m.* from frm_menu m " +
            "inner join frm_role_menu rm on m.menuId = rm.menuId " +
            "inner join frm_sysuser_role ru on ru.roleId = rm.roleId " +
            "inner join frm_sysuser fs on fs.userid = ru.userid " +
            "where fs.zt = 1 and fs.userId = #{userId} order by m.sequence")
    @Results(id="menuResultMap", value = {
            @Result(property = "menuId", column = "menuId"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "menuName", column = "menuName"),
            @Result(property = "css", column = "css"),
            @Result(property = "url", column = "url"),
            @Result(property = "type", column = "type"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "sequence", column = "sequence"),
            @Result(property = "zt", column = "zt"),
            @Result(property = "csjs", column = "csjs"),
            @Result(property = "gxsj", column = "gxsj"),

    })
    List<SysMenu> findMenuByUserId(int userId);



    /**
     * 功能描述:  根据用户名获取菜单
     * @author by tpc
     * @date 2019/10/16 9:12
     * @param userName
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    @Select("select distinct m.* from frm_menu m " +
            "inner join frm_role_menu rm on m.menuId = rm.menuId " +
            "inner join frm_sysuser_role ru on ru.roleId = rm.roleId " +
            "inner join frm_sysuser fs on fs.userid = ru.userid " +
            "where fs.zt = 1 and fs.userName = #{userName} order by m.sequence")
    @ResultMap(value={"menuResultMap"})
    List<SysMenu> findMenuByUserName(String userName);
}
