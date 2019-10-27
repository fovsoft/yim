package com.fovsoft.security.vefify;

import com.fovsoft.security.bean.SysMenu;
import com.fovsoft.security.bean.SysUser;
import com.fovsoft.security.service.SysMenuService;
import com.fovsoft.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private SysMenuService sysMenuService;


    /**
     *功能描述：通过获取数据的用户信息来判断
     * @author tpc
     * @date 2019/10/11
     * @param userName
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        System.out.println("前端需要验证的用户名为："+userName);
        SysUser sysUser = sysUserService.findByUserName(userName);

        if(sysUser == null){
            throw new UsernameNotFoundException("not have this user");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
            //根据用户id拿到菜单权限信息
        //Set<SysMenuPermission> sysMenuPermissionSet = sysMenuPermissionService.findMenuPermissionByUserId(sysUser.getUserid());
        List<SysMenu> sysMenuList = sysMenuService.findMenuByUserId(sysUser.getUserId());

        //设置一个字符串临时变量，用来拼接存放用户权限信息
        String menuStr = "";
        //把权限信息写入到权限认证集中
        for(SysMenu sysMenu:sysMenuList){
            if(sysMenu.getCss()==null){
                sysMenu.setCss("0");
            }
            menuStr = sysMenu.getMenuId()+";"+sysMenu.getParentId()+";"+sysMenu.getMenuName()+";"+ sysMenu.getCss()+";"+
                    sysMenu.getUrl()+";"+sysMenu.getType()+";"+sysMenu.getPermission()+";"+sysMenu.getSequence()+";"+sysMenu.getZt();
            //加入格式为url-permission
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(menuStr);
            authorities.add(authority);
        }

        System.out.println("数据库取出的用户名为："+sysUser.getUserName());
        //CustomUserDetails customUserDetails = new CustomUserDetails(sysUser);
        User user = new User(((SysUser) sysUser).getUserName(),sysUser.getPassword(),true,true,true,true,authorities);
        return user;
    }


}
