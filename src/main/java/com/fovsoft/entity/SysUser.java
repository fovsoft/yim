package com.fovsoft.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {

    private int userId;
    private String userName;
    private String password;
    private String department;
    private String sex;
    private Date birthday;
    private String sfzmhm;
    private String email;
    private String ipks;
    private String ipjs;
    private Date zhyxq;
    private Date mmyxq;
    private String yhlx;
    private String lxdh;
    private String zjdlip;
    private String zt;
    private Date cjsj;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSfzmhm() {
        return sfzmhm;
    }

    public void setSfzmhm(String sfzmhm) {
        this.sfzmhm = sfzmhm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpks() {
        return ipks;
    }

    public void setIpks(String ipks) {
        this.ipks = ipks;
    }

    public String getIpjs() {
        return ipjs;
    }

    public void setIpjs(String ipjs) {
        this.ipjs = ipjs;
    }

    public Date getZhyxq() {
        return zhyxq;
    }

    public void setZhyxq(Date zhyxq) {
        this.zhyxq = zhyxq;
    }

    public Date getMmyxq() {
        return mmyxq;
    }

    public void setMmyxq(Date mmyxq) {
        this.mmyxq = mmyxq;
    }

    public String getYhlx() {
        return yhlx;
    }

    public void setYhlx(String yhlx) {
        this.yhlx = yhlx;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getZjdlip() {
        return zjdlip;
    }

    public void setZjdlip(String zjdlip) {
        this.zjdlip = zjdlip;
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
}
