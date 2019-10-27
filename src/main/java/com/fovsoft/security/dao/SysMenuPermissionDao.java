package com.fovsoft.security.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author: by tpc
 * @date: 2019/10/15 17:36
 * @description: 获取菜单和操作权限
 **/

@Mapper
public interface SysMenuPermissionDao {


//    @Select("select d.menuId,d.parentId,d.menuName,d.url,e.permissionId,e.permissionName,e.permission from frm_menu d,frm_permission e ,\n" +
//            "(select a.* from frm_role_menu_permission a,frm_sysuser_role b where b.userId=#{userId} and a.roleId=b.roleId) c where d.menuId=c.menuId and c.permissionId=e.permissionId " )
//    @Results(id="menuPermitResultMap", value = {
//            @Result(property = "menuId", column = "menuId"),
//            @Result(property = "parentId", column = "parentId"),
//            @Result(property = "menuName", column = "menuName"),
//            @Result(property = "url", column = "url"),
//            @Result(property = "permissionId", column = "permissionId"),
//            @Result(property = "permissionName", column = "permissionName"),
//            @Result(property = "permission", column = "permission")
//    })
//    Set<SysMenuPermission> findMenuAndPermission(int userId);

}
