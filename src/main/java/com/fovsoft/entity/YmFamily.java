package com.fovsoft.entity;

import java.io.Serializable;

/**
 * @Author by tpc
 * @Date 2019/10/17 22:28
 * description: 移民贫困人员家庭信息表
 **/

public class YmFamily implements Serializable {

    private int       jtbh           ;// '家庭id',
    private String    szs            ;// '所在市',
    private String    szx            ;// '所在县',
    private String    szc            ;// '所在镇',
    private String    szz            ;// '所在村',
    private String    szjd           ;// '所在街道',
    private String    lxdh           ;// '联系电话',
    private String    khyh           ;// '开户银行（选填）',
    private String    yhkh           ;// '银行卡号（选填）',
    private String    pkhsx          ;// '贫困户属性',
    private String    sfdnytp        ;// '是否当年预脱贫',
    private String    jhtpnd         ;// '计划脱贫年度',
    private String    fpnd           ;// '返贫年度',
    private String    fpyy           ;// '返贫原因',
    private String    sfjls          ;// '是否军烈属',
    private String    sfydfpbqh      ;// '是否异地扶贫搬迁户',
    private String    bqfs           ;// '搬迁方式',
    private String    bqdz           ;// '搬迁地址'


    public int getJtbh() {
        return jtbh;
    }

    public void setJtbh(int jtbh) {
        this.jtbh = jtbh;
    }

    public String getSzs() {
        return szs;
    }

    public void setSzs(String szs) {
        this.szs = szs;
    }

    public String getSzx() {
        return szx;
    }

    public void setSzx(String szx) {
        this.szx = szx;
    }

    public String getSzc() {
        return szc;
    }

    public void setSzc(String szc) {
        this.szc = szc;
    }

    public String getSzz() {
        return szz;
    }

    public void setSzz(String szz) {
        this.szz = szz;
    }

    public String getSzjd() {
        return szjd;
    }

    public void setSzjd(String szjd) {
        this.szjd = szjd;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getYhkh() {
        return yhkh;
    }

    public void setYhkh(String yhkh) {
        this.yhkh = yhkh;
    }

    public String getPkhsx() {
        return pkhsx;
    }

    public void setPkhsx(String pkhsx) {
        this.pkhsx = pkhsx;
    }

    public String getSfdnytp() {
        return sfdnytp;
    }

    public void setSfdnytp(String sfdnytp) {
        this.sfdnytp = sfdnytp;
    }

    public String getJhtpnd() {
        return jhtpnd;
    }

    public void setJhtpnd(String jhtpnd) {
        this.jhtpnd = jhtpnd;
    }

    public String getFpnd() {
        return fpnd;
    }

    public void setFpnd(String fpnd) {
        this.fpnd = fpnd;
    }

    public String getFpyy() {
        return fpyy;
    }

    public void setFpyy(String fpyy) {
        this.fpyy = fpyy;
    }

    public String getSfjls() {
        return sfjls;
    }

    public void setSfjls(String sfjls) {
        this.sfjls = sfjls;
    }

    public String getSfydfpbqh() {
        return sfydfpbqh;
    }

    public void setSfydfpbqh(String sfydfpbqh) {
        this.sfydfpbqh = sfydfpbqh;
    }

    public String getBqfs() {
        return bqfs;
    }

    public void setBqfs(String bqfs) {
        this.bqfs = bqfs;
    }

    public String getBqdz() {
        return bqdz;
    }

    public void setBqdz(String bqdz) {
        this.bqdz = bqdz;
    }
}
