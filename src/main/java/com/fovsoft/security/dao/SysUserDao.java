package com.fovsoft.security.dao;

import com.fovsoft.security.bean.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11 14:58
 * @description:
 **/

@Mapper
public interface SysUserDao {

    /**
     * 列出所有用户
     * @return
     */
    @Select("select * from frm_sysuser s order by s.userId asc")
    @Results(id="sysUserResultMap",value = {
            @Result(property = "userId",column = "userId"),
            @Result(property = "userName",column = "userName"),
            @Result(property = "password",column = "password"),
            @Result(property = "department",column = "department"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sfzmhm",column = "sfzmhm"),
            @Result(property = "email",column = "email"),
            @Result(property = "ipks",column = "ipks"),
            @Result(property = "ipjs",column = "ipjs"),
            @Result(property = "zhyxq",column = "zhyxq"),
            @Result(property = "mmyxq",column = "mmyxq"),
            @Result(property = "yhlx",column = "yhlx"),
            @Result(property = "lxdh",column = "lxdh"),
            @Result(property = "zjdlip",column = "zjdlip"),
            @Result(property = "zt",column = "zt"),
            @Result(property = "cjsj",column = "cjsj"),
            @Result(property = "gxsj",column = "gxsj"),
    })
    List<SysUser> findAllUser();



    /**
     * 通过用户名去查找用户
     * @return
     */
    @Select("select * from frm_sysuser s where s.username=#{userName}")
    @ResultMap(value = {"sysUserResultMap"})
    SysUser findByUserName(String userName);


    /**
     * 通过用户名和密码去查找用户
     * @return
     */
    @Select("select * from frm_sysuser s where s.userName=#{userName} and s.password=#{password}")
    @ResultMap(value = {"sysUserResultMap"})
    SysUser findByUserNameAndPwd(String userName, String password);



    /**
     *功能描述:记录用户登陆ip地址
     * @author tpc
     * @date 2019/10/12
     * @param zjdlip, userName
     * @return int
     */
    @Update(value = "update frm_sysuser u set u.zjdlip =#{zjdlip} where u.userName = #{userName}")
    int updateUserZjdlip(String zjdlip, String userName);




    /**
     * @author:  by tpc
     * @date: 2019/10/17 22:01
     * @description:  新增用户信息
     */
    @Insert("insert into frm_sysuser(userName,password,department,sex,birthday,sfzmhm,email,ipks,ipjs,zhyxq,mmyxq,yhlx,lxdh,zjdlip,zt,cjsj) values(#{userName},#{password},#{department},#{sex},#{birthday},#{sfzmhm},#{email},#{ipks},#{ipjs},#{zhyxq},#{mmyxq},#{yhlx},#{lxdh},#{zjdlip},#{zt},#{cjsj})")
    int addSysUser(SysUser sysUser);





}
