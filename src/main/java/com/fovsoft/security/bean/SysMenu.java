package com.fovsoft.security.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11
 * @description: 对应数据库用户菜单表
 **/
public class SysMenu implements Serializable {

    private String menuId    ;
    private String parentId  ;
    private String menuName  ;
    private String css       ;
    private String url       ;
    private String type      ;
    private String permission ;


    private int sequence     ;
    private String zt        ;
    private Date cjsj        ;
    private Date gxsj        ;

    //用来存放子菜单的选项
    private List<SysMenu> childMenuList;

    public List<SysMenu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<SysMenu> childMenuList) {
        this.childMenuList = childMenuList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }
}
