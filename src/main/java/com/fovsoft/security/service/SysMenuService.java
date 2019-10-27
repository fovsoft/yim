package com.fovsoft.security.service;

import com.fovsoft.security.bean.SysMenu;
import com.fovsoft.security.dao.SysMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/16 9:01
 * @description: 菜单服务类
 **/

@Service
public class SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;


    /**
     * 功能描述:  根据用户id获取菜单信息
     * @author by tpc
     * @date 2019/10/16 9:04
     * @param userId
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    public List<SysMenu> findMenuByUserId(int userId){

        return sysMenuDao.findMenuByUserId(userId);
    }


    /**
     * 功能描述:  根据用户名获取菜单信息
     * @author by tpc
     * @date 2019/10/16 9:31
     * @param userName
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    public List<SysMenu> findMenuByUserName(String userName){
        return sysMenuDao.findMenuByUserName(userName);
    }
}
