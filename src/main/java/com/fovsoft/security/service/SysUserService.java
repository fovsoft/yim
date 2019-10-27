package com.fovsoft.security.service;

import com.fovsoft.security.bean.SysUser;
import com.fovsoft.security.dao.SysUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SysUserService {


    @Resource
    private SysUserDao sysUserDao;


    public SysUser findByUserName(String userName) {


        return sysUserDao.findByUserName(userName);

    }

    public SysUser findByUserNameAndPwd(String username,String password){
        return sysUserDao.findByUserNameAndPwd(username,password);
    }


    public int updateUserZjdlip(String zjdlip, String userName){
        return sysUserDao.updateUserZjdlip(zjdlip,userName);
    }

}
